
package com.viacron.utils.bbb;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ByteByByteStandaloneSetup extends ByteByByteStandaloneSetupGenerated{

	public static void doSetup() {
		new ByteByByteStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

