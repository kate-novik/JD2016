package by.it.sinkevich.project.java.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class Utility {

    public static String getParametersFromRequest(HttpServletRequest request) {
        StringBuilder debugInfo = new StringBuilder();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameter = parameterNames.nextElement();
            String value = request.getParameter(parameter);
            debugInfo.append(parameter).append("=").append(value).append(";\n");
        }
        return debugInfo.toString();
    }
}
