//package com.qdc.demoeurekaprovider1.config;
////
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
////import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
////import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
////
////@Configuration
////public class Oauth2ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
////    private static final String URL="http://localhost:8081/oauth/check_token";
////    @Override
////    public void configure(ResourceServerSecurityConfigurer resource) throws Exception{
////        //设置验证token的方法，即使用test和123456
////        RemoteTokenServices tokenServices=new RemoteTokenServices();
////        tokenServices.setCheckTokenEndpointUrl(URL);
////        tokenServices.setClientId("test");
////        tokenServices.setClientSecret("123456");
////        resource.tokenServices(tokenServices);
////        resource.resourceId("userall").stateless(true);
////
////    }
////}