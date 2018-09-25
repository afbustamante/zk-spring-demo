package net.andresbustamante.zktest.web;

import net.andresbustamante.zktest.model.Car;
import net.andresbustamante.zktest.services.CarService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.*;
import org.zkoss.zul.ext.Selectable;

import java.util.List;
import java.util.Set;

@VariableResolver(DelegatingVariableResolver.class)
public class SearchController extends SelectorComposer<Component> {

    private static final long serialVersionUID = 1L;

    @Wire
    private Textbox keywordBox;
    @Wire
    private Listbox carListbox;
    @Wire
    private Label modelLabel;
    @Wire
    private Label makeLabel;
    @Wire
    private Label priceLabel;
    @Wire
    private Label descriptionLabel;
    @Wire
    private Image previewImage;

    @WireVariable
    private CarService carService;

    @Listen("onClick = #searchButton")
    public void search(){
        String keyword = keywordBox.getValue();
        List<Car> result = carService.search(keyword);
        carListbox.setModel(new ListModelList<>(result));
    }

    @Listen("onSelect = #carListbox")
    public void showDetail(){
        Set<Car> selection = ((Selectable<Car>) carListbox.getModel()).getSelection();
        if (selection!=null && !selection.isEmpty()){
            Car selected = selection.iterator().next();
            previewImage.setSrc(selected.getPreview());
            modelLabel.setValue(selected.getModel());
            makeLabel.setValue(selected.getMake());
            priceLabel.setValue(selected.getPrice().toString());
            descriptionLabel.setValue(selected.getDescription());
        }
    }
}