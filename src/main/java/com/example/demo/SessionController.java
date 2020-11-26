package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/session")
public class SessionController {

    @ResponseBody
    @RequestMapping(value = "/getSession")
    public Map<String, Object> getSession(HttpServletRequest request) {
        request.getSession().setAttribute("userName", "test");
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("port",request.getLocalPort());
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/getName")
    public Map<String, Object> get(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        map.put("port",request.getLocalPort());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/test")
    public Map<String, Object> test(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("port",request.getLocalPort());
        System.out.println("port" + request.getLocalPort());
        return map;
    }
}
