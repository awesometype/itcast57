package com.wenbronk.test.freemarker;//package com.wenbronk.test.freemarker;
//
///**
// * @Author wenbronk <meng.wen@kangtaitong.cn>
// * @Date 2019-09-10 09:30
// * description:
// */
//public class Test {
//
//    //基于模板生成静态化文件
//    @Test
//    public void testGenerateHtml() throws IOException, TemplateException {
//        //创建配置类
//        Configuration configuration = new Configuration(Configuration.getVersion());
//        //设置模板路径
//        String classpath = this.getClass().getResource("/").getPath();
//        configuration.setDirectoryForTemplateLoading(new File(classpath + "/templates/"));
//        //设置字符集
//        configuration.setDefaultEncoding("utf‐8");
//        //加载模板
//        Template template = configuration.getTemplate("test1.ftl");
//        //数据模型
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "黑马程序员");
//        //静态化
//        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
//        //静态化内容
//        System.out.println(content);
//        InputStream inputStream = IOUtils.toInputStream(content);
//        //输出文件
//        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:/test1.html"));
//        int copy = IOUtils.copy(inputStream, fileOutputStream);
//    }
//
//    //基于模板字符串生成静态化文件
//    @Test
//    public void testGenerateHtmlByString() throws IOException, TemplateException {
//        //创建配置类
//        Configuration configuration = new Configuration(Configuration.getVersion());
//        //模板内容，这里测试时使用简单的字符串作为模板
//        String templateString = "" +
//                "<html>\n" +
//                " <head></head>\n" +
//                " <body>\n" +
//                " 名称：${name}\n" +
//                " </body>\n" +
//                "</html>";
//        //模板加载器
//        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
//        stringTemplateLoader.putTemplate("template", templateString);
//        configuration.setTemplateLoader(stringTemplateLoader);
//        //得到模板
//        Template template = configuration.getTemplate("template", "utf‐8");
//        //数据模型
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "黑马程序员");
//        //静态化
//        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
//        //静态化内容
//        System.out.println(content);
//        InputStream inputStream = IOUtils.toInputStream(content);
//        //输出文件
//        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:/test1.html"));
//        IOUtils.copy(inputStream, fileOutputStream);
//    }
//}
