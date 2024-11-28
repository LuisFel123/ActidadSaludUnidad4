/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manipuladatos;

import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named
@RequestScoped
public class ButtonView {

    private MenuModel model;
    private boolean verificaru;
    private boolean verificarf;

    public boolean isVerificaru() {
        return verificaru;
    }

    public void setVerificaru(boolean verificaru) {
        this.verificaru = verificaru;
    }

    public boolean isVerificarf() {
        return verificarf;
    }

    public void setVerificarf(boolean verificarf) {
        this.verificarf = verificarf;
    }

    @PostConstruct

    public void init() {
        model = new DefaultMenuModel();

        //First submenu
        DefaultMenuItem item = DefaultMenuItem.builder()
                .value("External")
                .url("http://www.primefaces.org")
                .icon("pi pi-home")
                .build();

        DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
                .label("Dynamic Submenu")
                .addElement(item)
                .build();

        model.getElements().add(firstSubmenu);

        //Second submenu
        item = DefaultMenuItem.builder()
                .id("mniSave")
                .value("Save")
                .icon("pi pi-save")
                .function((i) -> save())
                .update("messages")
                .build();

        DefaultSubMenu secondSubmenu = DefaultSubMenu.builder()
                .label("Dynamic Actions")
                .addElement(item)
                .build();

        item = DefaultMenuItem.builder()
                .value("Delete")
                .icon("pi pi-times")
                .command("#{buttonView.delete}")
                .ajax(false)
                .build();
        secondSubmenu.getElements().add(item);

        model.getElements().add(secondSubmenu);
    }

    public MenuModel getModel() {
        return model;
    }

    public String save() {
        return null;
    }

    public void update() {
        addMessage("Data updated");
    }

    public void delete() {
        addMessage("Data deleted");
    }

    public String sleepAndSave() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return save();
    }

    public void sleepAndUpdate() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        update();
    }

    public void sleepAndDelete() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        delete();
    }

    public void buttonAction() {
        addMessage("Welcome to PrimeFaces!!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
