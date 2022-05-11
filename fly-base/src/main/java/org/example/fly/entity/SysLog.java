package org.example.fly.entity;

import javafx.scene.shape.VLineTo;
import lombok.Data;
import org.apache.tomcat.util.descriptor.web.SecurityRoleRef;
import org.aspectj.weaver.ast.Or;

/**
 * @ClassName SysLog
 * @Author moon
 * @Date 2022/3/7
 * @Version V1.0
 **/
@Data
public class SysLog {

    private String className;
    private String methodName;
    private String params;
    private Long   exeuTime;
    private String remark;
    private String createTime;

}
