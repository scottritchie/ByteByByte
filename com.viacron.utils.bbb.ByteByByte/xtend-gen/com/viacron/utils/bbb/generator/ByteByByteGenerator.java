package com.viacron.utils.bbb.generator;

import com.viacron.utils.bbb.jgenerator.JByteByByteGenerator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

@SuppressWarnings("all")
public class ByteByByteGenerator implements IGenerator {
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    JByteByByteGenerator _jByteByByteGenerator = new JByteByByteGenerator();
    JByteByByteGenerator gen = _jByteByByteGenerator;
    gen.doGenerate(resource, fsa);
  }
}
