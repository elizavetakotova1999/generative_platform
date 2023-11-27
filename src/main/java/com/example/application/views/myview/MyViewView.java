package com.example.application.views.myview;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;

@PageTitle("My View")
@Route(value = "my-view", layout = MainLayout.class)
@Uses(Icon.class)
public class MyViewView extends Composite<VerticalLayout> {

    public MyViewView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        MultiSelectComboBox multiSelectComboBox = new MultiSelectComboBox();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        Details details = new Details();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn2.getStyle().set("flex-grow", "1");
        multiSelectComboBox.setLabel("Multi-Select Combo Box");
        multiSelectComboBox.setWidth("min-content");
        setMultiSelectComboBoxSampleData(multiSelectComboBox);
        layoutColumn4.setWidth("100%");
        layoutColumn4.getStyle().set("flex-grow", "1");
        layoutColumn3.getStyle().set("flex-grow", "1");
        details.setWidth("100%");
        setDetailsSampleData(details);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(multiSelectComboBox);
        layoutRow.add(layoutColumn4);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(details);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setMultiSelectComboBoxSampleData(MultiSelectComboBox multiSelectComboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        multiSelectComboBox.setItems(sampleItems);
        multiSelectComboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setDetailsSampleData(Details details) {
        Span name = new Span("Sophia Williams");
        Span email = new Span("sophia.williams@company.com");
        Span phone = new Span("(501) 555-9128");
        VerticalLayout content = new VerticalLayout(name, email, phone);
        content.setSpacing(false);
        content.setPadding(false);
        details.setSummaryText("Contact information");
        details.setOpened(true);
        details.setContent(content);
    }
}
