package cs.phd.property.inspector.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.iron.widget.IronPages;
import com.vaadin.polymer.neon.widget.NeonAnimatedPages;
import com.vaadin.polymer.paper.widget.PaperItem;
import com.vaadin.polymer.paper.widget.PaperTab;

public class InspectorViewImpl<T> extends Composite implements InspectorView<T> {

	@UiTemplate("InspectorView.ui.xml")
	interface InspectorViewUiBinder extends UiBinder<Widget, InspectorViewImpl> {
	}

	private static InspectorViewUiBinder uiBinder = GWT.create(InspectorViewUiBinder.class);

	//Top part of UI
	@UiField
	PaperTab commonViewTab;
	@UiField
	PaperTab diffViewTab;
	@UiField
	PaperTab abstractionViewTab;
	//Left part of UI
	@UiField
	PaperItem files;
	@UiField
	PaperItem abstractions;
	@UiField
	PaperItem filters;
	@UiField
	IronPages settingsMenu;
	@UiField
	HTMLPanel fileSettingsMenu;
	@UiField
	HTMLPanel abstractionSettingsMenu;
	@UiField
	HTMLPanel filterSettingsMenu;
	//Center Part of UI
	@UiField
	NeonAnimatedPages pages;
	@UiField
	HTMLPanel commonPropertiesView;
	@UiField
	HTMLPanel diffPropertiesView;
	@UiField
	HTMLPanel abstractionPropertiesView;
	

	private Presenter<T> presenter;

	public InspectorViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		files.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.onFileFieldClicked();
			}
		});
		
		abstractions.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.onAbstractionFieldClicked();
			}
		});
		
		filters.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.onFilterFieldClicked();
			}
		});

		commonViewTab.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.onCommonTabClicked();
			}
		});
		
		diffViewTab.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.onDiffTabClicked();
			}
		});
		
		abstractionViewTab.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.onAbstractionTabClicked();
			}
		});
		
		//Initialize view
		//presenter.onCommonTabClicked();
	}

	@Override
	public void setPresenter(Presenter<T> presenter) {
		this.presenter = presenter;
	}

	public Widget asWidget() {
		return this;
	}

	@Override
	public HasWidgets getFilterSettingsMenuWidget() {
		return filterSettingsMenu;
	}
	
	@Override
	public HasWidgets getFileSettingsMenuWidget() {
		return fileSettingsMenu;
	}
	
	@Override
	public HasWidgets getAbstractionSettingsMenuWidget() {
		return abstractionSettingsMenu;
	}

	@Override
	public HasWidgets getCommonPropertiesWidget() {
		return commonPropertiesView;
	}
	
	@Override
	public HasWidgets getDiffPropertiesWidget() {
		return diffPropertiesView;
	}
	
	@Override
	public HasWidgets getAbstractionPropertiesWidget() {
		return abstractionPropertiesView;
	}

	public void switchToCommonPropertiesView() {
		pages.select("0");
	}
	
	public void switchToDiffPropertiesView() {
		pages.select("1");
	}
	
	public void switchToAbstractionPropertiesView() {
		pages.select("2");
	}
	
	public void switchToFileSettingsView() {
		settingsMenu.select("0");
	}
	
	public void switchToAbstractionSettingsView() {
		settingsMenu.select("1");
	}
	
	public void switchToFilterSettingsView() {
		settingsMenu.select("2");
	}

}
