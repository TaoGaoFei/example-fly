package org.example.fly.report.handler;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.util.List;

/**
 * @ClassName CustomCellWriteHandler
 * @Author moon
 * @Date 2021/12/8
 * @Version V1.0
 **/
public class CustomCellWriteHandler implements CellWriteHandler {

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<WriteCellData<?>> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {

        System.out.println("进入第" +  cell.getRowIndex() + "行,第" + cell.getColumnIndex() + "列数据...");
        if (cell.getColumnIndex() == 0){
            CellStyle cellStyle = cell.getCellStyle();
            cellStyle.setWrapText(true);
            cell.setCellStyle(cellStyle);
        }
        if (cell.getRowIndex() >= 3 && 3 == cell.getColumnIndex()){
            // 计算总价
            int actualCellRowNum = cell.getRowIndex() + 1;
            // 设置单元格公式
            cell.setCellFormula("B"+actualCellRowNum+"*C"+actualCellRowNum);
            System.out.println("第" + cell.getRowIndex() + "行,第" + cell.getColumnIndex() + "总价写入公式完成");
        }
    }
}
