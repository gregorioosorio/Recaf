package me.coley.recaf;

import java.io.File;
import java.util.concurrent.Callable;

import picocli.CommandLine.Option;

public class LaunchParams implements Callable<Void> {
	@Option(names = { "-i", "--input" }, description = "Jar file to read.")
	public File initialFile;
	@Option(names = { "-c", "--class" }, description = "Initial class to open.")
	public String initialClass;
	@Option(names = { "-a", "--agent" }, description = "Flag for when Recaf is initialized as an agent.", hidden = true)
	public boolean agent;

	@Override
	public Void call() throws Exception {
		if (agent) Logging.info("Initialized as agent");
		if (initialFile != null) Logging.info("CLI file: " + initialFile);
		if (initialClass != null) Logging.info("CLI class: " + initialClass);
		return null;
	}
}
