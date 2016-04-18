package cs.phd.property.inspector.client.view.settingsViews;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.vaadin.polymer.iron.widget.event.IronChangeEvent;
import com.vaadin.polymer.paper.widget.PaperCheckbox;

public class FileItem extends Composite  {

    interface ItemUiBinder extends UiBinder<HTMLPanel, FileItem> {
    }

    private static ItemUiBinder ourUiBinder = GWT.create(ItemUiBinder.class);

    @UiField Element title;
    @UiField PaperCheckbox done;

    public FileItem() {
      initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("done")
    protected void change(IronChangeEvent ev) {
      if (done.getActive()) {
        title.addClassName("done");
      } else {
        title.removeClassName("done");
      }
    }
    public String getTitle() {
      return title.getInnerText();
    }
    public void setTitle(String s) {
      title.setInnerText(s);
    }

    public boolean isDone() {
      return done.getActive();
    }
    public void setDone(boolean b) {
      done.setActive(b);
    }
  }