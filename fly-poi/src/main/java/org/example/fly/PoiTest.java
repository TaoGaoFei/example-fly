package org.example.fly;

import com.sun.org.apache.xpath.internal.axes.OneStepIteratorForward;
import org.example.fly.utils.ExcelToHtml;

import java.io.File;

/**
 * @ClassName PoiTest
 * @Description: TODO
 * @Author moon
 * @Date 2021/5/25
 * @Version V1.0
 **/
public class PoiTest {

    public static void main(String[] args) {

        String path = "D:\\pms\\file\\gatherBill\\出口表20210520103241347.xlsx";
        String content = ExcelToHtml.excelWriteToHtml(path);
        String exportPath = "D:\\pms\\file\\gatherBill\\出口表20210520103241347.html";
        ExcelToHtml.writeFile(content,exportPath);

    }
}
