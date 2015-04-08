package com.bbb.example;

import java.io.File;

import com.viacron.greenball.app.bbb.Attribute;
import com.viacron.greenball.app.bbb.MetaModel;
import com.viacron.greenball.app.bbb.MetaModelElement;
import com.viacron.greenball.app.bbb.MissingAttributeException;
import com.viacron.greenball.app.bbb.PackageSubType;
import com.viacron.greenball.common.CommonLoader;

public class MetaModelTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String orgId ="ABC-DEF";
		String orgName = "Test";
		
		MetaModel mm = new MetaModel();
		mm.setId(orgId);

		PackageSubType pckg = new PackageSubType();
		pckg.setName(orgName);

		MetaModelElement mme = new MetaModelElement();
		mme.setLabeled(true);
		mme.setName("Root");

		Attribute attr = new Attribute();
		attr.setName("todo");
		attr.setMulti(false);
		attr.setTypeRef("string");
		mme.getAttributes().add(attr);
		pckg.getElement().add(mme);

		mm.getPckg().add(pckg);
		
		CommonLoader loader = new CommonLoader();
		
		File file = new File("C:\\Users\\Scott\\Documents\\Programs\\ByteByByte\\Sandbox");
		String errMsg = loader.saveMetaModel(mm, file);
		System.out.println("errMsg: " + errMsg);
	}

}
