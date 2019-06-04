package com.tacyanne.FolhaDePagamento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;
import org.junit.Test;

public class RunJBehave extends JUnitStories {

	
	    @Override
	    public Configuration configuration() {
	        return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader())).useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE));
	    }
	     
	    @Override
	    public List<CandidateSteps> candidateSteps() {
	        return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
	    }
	         
	    @Override
		public InjectableStepsFactory stepsFactory() {
	        ArrayList<Steps> stepFileList = new ArrayList<Steps>();
	        //stepFileList.add(new CalcSteps());
	        stepFileList.add(new CalcInssIRRF());
			return new InstanceStepsFactory(configuration(), stepFileList);
		}
	    
	
	    @Override
	    protected List<String> storyPaths() {
	    	 return new StoryFinder().
	                 findPaths(CodeLocations.codeLocationFromClass(
	                         this.getClass()), 
	                         Arrays.asList("com/tacyanne/FolhaDePagamento/*.story"), 
	                         Arrays.asList(""));

	    	
	        //return Arrays.asList("model//Usuario.story");
	    }
	     
	    @Override
	    @Test
	    public void run() {
	        super.run();
	    }
}	