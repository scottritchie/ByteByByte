/*
* generated by Xtext
*/
package com.viacron.utils.bbb;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class ByteByByteUiInjectorProvider implements IInjectorProvider {
	
	public Injector getInjector() {
		return com.viacron.utils.bbb.ui.internal.ByteByByteActivator.getInstance().getInjector("com.viacron.utils.bbb.ByteByByte");
	}
	
}
