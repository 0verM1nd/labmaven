package com.test;

//dependency on Apache commons-collections
import org.apache.commons.collections.Predicate;

class Project {

  public static void test() {
    System.out.println("test");
  }
  
  public static void main(String[] args) {
    System.out.println("Hellow MTN");
  }

}
public final class SpringCli {

	private SpringCli() {
	}	public static void main(String... args) {
		System.setProperty("java.awt.headless", Boolean.toString(true));
		LogbackInitializer.initialize();

		CommandRunner runner = new CommandRunner("spring");
		ClassUtils.overrideThreadContextClassLoader(createExtendedClassLoader(runner));
		runner.addCommand(new HelpCommand(runner));
		addServiceLoaderCommands(runner);
		runner.addCommand(new ShellCommand())
		runner.addCommand(new HintCommand(runner))
		runner.setOptionCommands(HelpCommand.class, VersionCommand.class);
		runner.setHiddenCommands(HintCommand.class)
		int exitCode = runner.runAndHandleErrors(args);
		if (exitCode != 0) {
			// If successful, leave it to run in case it's a server app
			System.exit(exitCode);	}}