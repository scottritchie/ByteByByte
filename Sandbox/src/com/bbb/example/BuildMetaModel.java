package com.bbb.example;

import com.viacron.greenball.app.bbb.Attribute;
import com.viacron.greenball.app.bbb.MetaModel;
import com.viacron.greenball.app.bbb.MetaModelElement;
import com.viacron.greenball.app.bbb.PackageSubType;
import com.viacron.greenball.app.bbb.Variable;
import com.viacron.greenball.app.bbb.MissingAttributeException;

public class BuildMetaModel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MetaModel mm = new MetaModel();
		mm.setId("a391b25e-6786-4855-8836-30e62ba21f8a");
		PackageSubType pckg = new PackageSubType();
		pckg.setName("AAA");

		MetaModelElement element0 = new MetaModelElement();
		element0.setName("Root");
		element0.setLabeled(true);
		element0.setSuperType("");

		Attribute attr0 = new Attribute();
		attr0.setName("Organization");
		attr0.setTypeRef("Organization");
		attr0.setMulti(false);
		element0.getAttributes().add(attr0);

		MetaModelElement element1 = new MetaModelElement();
		element1.setName("Organization");
		element1.setLabeled(true);
		element1.setSuperType("");

		Variable var1 = new Variable();
		var1.setName("Todo");
		var1.setDatatype("String");
		var1.setMulti(false);
		element1.getVariables().add(var1);

		pckg.getElement().add(element0);
		pckg.getElement().add(element1);

		mm.getPckg().add(pckg);

		try {
			System.out.println("mm: " + mm.packStr());
		} catch (MissingAttributeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
