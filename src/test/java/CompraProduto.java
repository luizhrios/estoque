import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;

public class CompraProduto extends JUnitStory
{
	@Override
	public Configuration configuration()
	{
		Keywords keywords = new LocalizedKeywords(new Locale("pt"));
		return new MostUsefulConfiguration()
				// where to find the stories
				.useKeywords(keywords).useStoryLoader(new LoadFromClasspath(this.getClass()))
				.useStepCollector(new MarkUnmatchedStepsAsPending(keywords))
                .useStoryParser(new RegexStoryParser(keywords))
				// CONSOLE and TXT reporting
				.useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats()
						.withFormats(Format.CONSOLE, Format.TXT));
	}

	// Here we specify the steps classes
	@Override
	public InjectableStepsFactory stepsFactory()
	{
		// varargs, can have more that one steps classes
		return new InstanceStepsFactory(configuration(), new EstoqueStory());
	}

}