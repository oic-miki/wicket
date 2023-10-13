package wicket;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	private Integer number = 0;
	
	public HomePage() {
		
		final Label helloMessage = new Label("helloMessage", "Hello WicketWorld!");
		add(helloMessage.setOutputMarkupId(true));
		
		final Form<Void> form = new Form<>("form");
		
		final AjaxButton secondSubmitter = new AjaxButton("submit2", Model.of("Second submitter")) {
			
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void onSubmit(AjaxRequestTarget target) {
				
				number++;
				
				helloMessage.setDefaultModelObject(number.toString());
				
				target.add(helloMessage);
				
			}
			
		};
		form.add(secondSubmitter);
		
	    form.setDefaultButton(secondSubmitter);
	    
		add(form);
		
	}

}
