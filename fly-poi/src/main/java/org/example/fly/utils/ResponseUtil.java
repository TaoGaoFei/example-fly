package org.example.fly.utils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName ResponseUtil
 * @Author moon
 * @Date 2021/5/26
 * @Version V1.0
 **/
public class ResponseUtil extends HttpServlet {

    /**
     * 序列化码
     */
    private static final long serialVersionUID = 4312868947607181532L;

    /**
     * 使用OutputStream流输出中文
     * @param response
     */
    public void doPost(HttpServletResponse response){
        // 1. 通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setHeader("content-type", "text/html;charset=UTF-8");
        // 2. 输入文件
        ServletOutputStream outputStream = null;
        String data = "中国";
        try {
            outputStream = response.getOutputStream();
            byte[] bytes = data.getBytes("UTF-8");
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 注：输出数字要先将数字转成字符串 这样获取字符串得字节码就可以使用OutputStream进行输出
    }

    /**
     * 使用PrintWriter流输出中文
     * @param response
     */
    private void doPost2(HttpServletResponse response) throws IOException {
        // 1.设置输出的编码格式
        response.setCharacterEncoding("UTF-8");
        String date = "中国";
        // 2.获取字符流
        PrintWriter writer = response.getWriter();
        writer.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
        writer.write(date);
    }

    /**
     * 文件下载
     */
    private void Pull(HttpServletResponse response) throws IOException {
        // 1. 下载的文件名称
        String fileName = "fly.txt";
        // 2. 设置Content-Disposition响应头控制游览器以下载的形式打开文件
        response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName).getBytes("UTF-8"), "ISO8859_1"));

        // 3. 要下载文件的文件输入流
        FileInputStream in = new FileInputStream(fileName);

        // 4. 创建一个数据缓存区
        int len = 0;
        byte[] buffer = new byte[1024];
        ServletOutputStream out = response.getOutputStream();

        while ((len = in.read(buffer)) > 0){
            // 5. 使用out将缓存区的数据输出到游览器
            out.write(buffer,0,len);
        }
        // 6. 关闭流
        in.close();
    }


}
