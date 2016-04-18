/**
 * 
 */
package cs.phd.property.inspector.client.view.settingsViews;


import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Christoph
 *
 */
public class FilesSettingsViewImpl<T> extends Composite implements FilesSettingsView<T> {

	@UiTemplate("FilesSettingsView.ui.xml")
	interface FilesSettingsViewUiBinder extends UiBinder<Widget, FilesSettingsViewImpl> {
	}

	private static FilesSettingsViewUiBinder uiBinder = GWT.create(FilesSettingsViewUiBinder.class);
	
	@UiField
	HTMLPanel content;
	
	private List<FileItem> items = new ArrayList<>();

	
	private Presenter<T> presenter;

	public FilesSettingsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		FileItem item = new FileItem();
	    item.setTitle("Title(10)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Foo(20)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Bar(39)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Foo(20)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Bar(39)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Foo(20)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Bar(39)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Foo(20)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Bar(39)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Foo(20)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Bar(39)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Foo(20)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Bar(39)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Foo(20)");
	    content.add(item);
	    items.add(item);
	    
	    item = new FileItem();
	    item.setTitle("Bar(39)");
	    content.add(item);
	    items.add(item);
	    
	    
	}

	@Override
	public void setPresenter(Presenter<T> presenter) {
		this.presenter = presenter;
	}

	public Widget asWidget() {
		return this;
	}
}
