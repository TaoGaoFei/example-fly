package org.example.fly.report.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.example.fly.report.entity.DemoData;
import org.example.fly.report.handler.CustomCellWriteHandler;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EasyExcelDemo
 * @Author moon
 * @Date 2021/12/8
 * @Version V1.0
 **/
public class EasyExcelDemo {

    public static void main(String[] args) throws IOException {

        String outPath = "F:\\out.xlsx";
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:/template/easyDemo.xlsx");
        if (resource.exists()){

            // 初始化数据
            List<DemoData> list = initData();

            // 获取模板流
            InputStream inputStream = resource.getInputStream();
            // 数据写出
            ExcelWriter writer = EasyExcel.write(new File(outPath)).withTemplate(inputStream).build();
            WriteSheet sheet = EasyExcel.writerSheet(0)
                    .registerWriteHandler(new CustomCellWriteHandler())
                    .build();
            FillConfig config = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
            Map<String, Object> map = new HashMap<>();

            map.put("image",picture().toByteArray());
            writer.fill(map,config, sheet);
            // 填充列表数据
            writer.fill(new FillWrapper("list", list), config ,sheet);

            // 设置强制计算
            Workbook workbook = writer.writeContext().writeWorkbookHolder().getWorkbook();
            workbook.setForceFormulaRecalculation(true);
            writer.finish();
        }
    }

    private static List<DemoData> initData(){
        ArrayList<DemoData> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++)
        {
            DemoData demoData = new DemoData();
            demoData.setName("商品名称" + i);
            demoData.setNum(new BigDecimal(i));
            demoData.setPrice(new BigDecimal(i));
            list.add(demoData);
        }
        return list;
    }

    private static ByteArrayOutputStream picture() throws IOException {
        ByteArrayOutputStream byteArrayOut = null;
        try {
            String imageUrlStr = "img/img1.png";
            InputStream inputStream = new ClassPathResource(imageUrlStr).getInputStream();
            BufferedImage bufferImg = ImageIO.read(inputStream);
            byteArrayOut = new ByteArrayOutputStream();
            // 图片后缀格式
            String sfx = imageUrlStr.substring(imageUrlStr.lastIndexOf(".") + 1);
            ImageIO.write(bufferImg, sfx, byteArrayOut);
            bufferImg.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOut != null) {
                byteArrayOut.close();
            }
        }
        return byteArrayOut;
    }

}
