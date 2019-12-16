package com.fengf.bms.filter;

import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;

import java.text.MessageFormat;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {
    private  static final String ROLE_STRING = "roles[{0}]";
    private  String  filterChainDefinitions;//配置文件中默认的地址
    @Override
    public void setFilterChainDefinitions(String definitions) {
        filterChainDefinitions = definitions;
        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection("urls");
        if (CollectionUtils.isEmpty(section)) {
            section = ini.getSection("");
        }
        //模拟从数据库中读取的数据
        Map<String,String[]> permsmap = new Hashtable<>();
        permsmap.put("/test/dotest1.html",new String[]{"test"});
        permsmap.put("/test/dotest2.html",new String[]{"test","guest"});
        permsmap.put("/test/dotest3.html",new String[]{"admin"});

        for (String url : permsmap.keySet()){
            String[] roles = permsmap.get(url);
            StringBuffer stringBuffer = new StringBuffer();
            for (String role:roles){
                stringBuffer.append(role).append(",");
            }
            String str = stringBuffer.substring(0,stringBuffer.length()-1);
            //roles[admin,test]
            section.put(url, MessageFormat.format(ROLE_STRING,str));
//            System.out.println("str = "+MessageFormat.format(ROLE_STRING,str));
        }
        this.setFilterChainDefinitionMap(section);
    }

    public void update(){
        synchronized (this){
            try {
                //获取manager对象
                AbstractShiroFilter shiroFilter = (AbstractShiroFilter)this.getObject();
                PathMatchingFilterChainResolver resolver = (PathMatchingFilterChainResolver)shiroFilter.getFilterChainResolver();
                DefaultFilterChainManager manager = (DefaultFilterChainManager)resolver.getFilterChainManager();

                manager.getFilterChains().clear();
                this.getFilterChainDefinitionMap().clear();
                //动态更新
                this.setFilterChainDefinitions(filterChainDefinitions);
                this.setFilterChainDefinitions("/test/dotest4.html = authc,roles[admin]");

                Map<String, String> chains = this.getFilterChainDefinitionMap();
                if (!CollectionUtils.isEmpty(chains)) {
                    Iterator var12 = chains.entrySet().iterator();

                    while(var12.hasNext()) {
                        Map.Entry<String, String> entry = (Map.Entry)var12.next();
                        String url = (String)entry.getKey();
                        String chainDefinition = (String)entry.getValue();
                        manager.createChain(url, chainDefinition);
                    }
                }
            }catch (Exception e){

            }
        }
    }
}
