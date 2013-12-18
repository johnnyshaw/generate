package com.johnny.generator.gen;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.johnny.constant.TemplateConstant;
import com.johnny.generator.abs.AbstractGenerator;
import com.johnny.model.GeneratorModel;


public class DaoGenerator extends AbstractGenerator {

	public void genDaoInterface(String fileName){
		GeneratorModel daoModel=new GeneratorModel();
		daoModel.setPackageName(TemplateConstant.DAO_PACKAGE);
		String className=StringUtils.substringBefore(fileName, ".");
		daoModel.setClassName(className);
		 Map<String, Object> data = new HashMap<String, Object>();
	     data.put("model", daoModel);
	     String filePath=new String("src/"+package2path(TemplateConstant.DAO_PACKAGE)+"/"+fileName);
	     super.generate(TemplateConstant.INTERFACE_DAO_TEMPLATE, data, filePath);
	}
	public void genDaoImpl(String fileName){
		GeneratorModel daoModel=new GeneratorModel();
		daoModel.setPackageName(TemplateConstant.IMPL_DAO_PACKAGE);
		String className=StringUtils.substringBefore(fileName, ".");
		daoModel.setClassName(className);
		String impInterface=StringUtils.substringBefore(fileName,"Impl");
		String changeClass=StringUtils.substringBefore(impInterface, "Dao");
		daoModel.setImplementsName(impInterface);
		daoModel.setChangeClass(changeClass);
		 Map<String, Object> data = new HashMap<String, Object>();
	     data.put("model", daoModel);
	     String filePath=new String("src/"+package2path(TemplateConstant.IMPL_DAO_PACKAGE)+"/"+fileName);
	     super.generate(TemplateConstant.IMPL_DAO_TEMPLATE, data, filePath);
	}
	public void genAll(String objectName) {
		genDaoInterface(objectName+"Dao.java");
		genDaoImpl(objectName+"DaoImpl.java");
	}
}
