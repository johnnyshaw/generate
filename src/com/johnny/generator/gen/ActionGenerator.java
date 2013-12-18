package com.johnny.generator.gen;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.johnny.constant.TemplateConstant;
import com.johnny.generator.abs.AbstractGenerator;
import com.johnny.model.GeneratorModel;


public class ActionGenerator extends AbstractGenerator{

	public void genServiceInterface(String fileName){
		GeneratorModel daoModel=new GeneratorModel();
		daoModel.setPackageName(TemplateConstant.SERVICE_PACKAGE);
		String className=StringUtils.substringBefore(fileName, ".");
		daoModel.setClassName(className);
		 Map<String, Object> data = new HashMap<String, Object>();
	     data.put("model", daoModel);
	     String filePath=new String("src/"+package2path(TemplateConstant.SERVICE_PACKAGE)+"/"+getModuleName()+"/"+fileName);
	     super.generate(TemplateConstant.INTERFACE_SERVICE_TEMPLATE, data, filePath);
	}
	public void genDaoImpl(String fileName){
		GeneratorModel daoModel=new GeneratorModel();
		daoModel.setPackageName(TemplateConstant.IMPL_SERVICE_PACKAGE);
		String className=StringUtils.substringBefore(fileName, ".");
		daoModel.setClassName(className);
		String impInterface=StringUtils.substringBefore(fileName,"Impl");
		String changeClass=StringUtils.substringBefore(impInterface, "Action");
		daoModel.setImplementsName(impInterface);
		daoModel.setChangeClass(changeClass);
		 Map<String, Object> data = new HashMap<String, Object>();
	     data.put("model", daoModel);
	     String filePath=new String("src/"+package2path(TemplateConstant.IMPL_SERVICE_PACKAGE)+"/"+fileName);
	     super.generate(TemplateConstant.IMPL_SERVICE_TEMPLATE, data, filePath);
	}
	
	public void genAction(String fileName){
		fileName+="Action.java";
		GeneratorModel daoModel=new GeneratorModel();
		daoModel.setPackageName(TemplateConstant.ACTIOIN_PACKAGE);
		String className=StringUtils.substringBefore(fileName, ".");
		daoModel.setClassName(className);
		 Map<String, Object> data = new HashMap<String, Object>();
	     data.put("model", daoModel);
	     System.out.println();
	     String filePath=new String("src/"+package2path(TemplateConstant.ACTIOIN_PACKAGE)+"/"+fileName);
	     super.generate(TemplateConstant.ACTION_TEMPLATE, data, filePath);
	}
	
	public void genAll(String objectName) {
//		genServiceInterface(objectName+"Service.java");
//		genDaoImpl(objectName+"ServiceImpl.java");
		genAction(objectName);
	}
}
