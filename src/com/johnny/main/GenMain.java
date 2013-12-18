package com.johnny.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.johnny.generator.gen.ActionGenerator;
import com.johnny.generator.gen.DaoGenerator;
import com.johnny.generator.gen.ServiceGenerator;
import com.johnny.model.JavaModel;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/** *//**
 * Action代码产生器,根据Action类模板用FreeMarker产生Action代码.
 * <br>模板例子请参照config目录下的action.ftl
 * @author HuangYu
 */
public class GenMain {

    private Configuration cfg;
    private String templateDir = "GenTemplate";
    private String templateName = "DaoInterface.java.ftl";
    private String outputDir = "C:/codegen/output";
    
    public GenMain() throws IOException{
        init();
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public void setTemplateDir(String templateDir) throws IOException {
        this.templateDir = templateDir;
        cfg.setDirectoryForTemplateLoading(new File(templateDir));
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    
    public void init() throws IOException {
        // Initialize the FreeMarker configuration;
        // - Create a configuration instance
        cfg = new Configuration();
        File templateDir = new File(this.templateDir);
        cfg.setDirectoryForTemplateLoading(templateDir);
        cfg.setLocale(Locale.CHINA);
        cfg.setDefaultEncoding("UTF-8");
    }
    
    /** *//**
     * 根据Model类产生Action类代码，如UserAction.java
     * @param className Model类的名字，如：User
     */
    public void generate(String className) throws IOException{
    	JavaModel model=new JavaModel();
    	model.setClassName(className);
        // Build the data-model
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("model", model);
        
        // Get the templat object
        Template template = cfg.getTemplate(templateName);
        
        org.apache.commons.io.FileUtils.forceMkdir(new File(outputDir));
        File output = new File(outputDir, className + "Service.java");
        Writer writer = new FileWriter(output);
        
        // Merge the data-model and the template
        try {
            template.process(data, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
    
    public static void run(){
    	String tempStr = "UserLucky";
    	DaoGenerator daoGenerator=new DaoGenerator();
    	daoGenerator.setModuleName(tempStr);
    	daoGenerator.genAll(tempStr);
//    	ServiceGenerator serviceGenerator=new ServiceGenerator();
//    	daoGenerator.setModuleName(tempStr);
//    	serviceGenerator.genAll(tempStr);
    	ActionGenerator actionGenerator = new ActionGenerator();
    	actionGenerator.setModuleName(tempStr);
    	actionGenerator.genAll(tempStr);
    	System.out.println("代码已生成");
    }
  
    /** *//**
     * 测试，根据Model类生成相应的Action
     */
    public static void main(String[] args) throws IOException {
//        GenMain gen = new GenMain();
//        gen.generate("User");
//        System.out.println("代码已生成，位置:"+gen.outputDir);
    	run();
//    	daoGenerator.genDaoInterface("UserDao.java");
//    	daoGenerator.genDaoImpl("UserDaoImpl.java");
    	
    }

}
