package dev.projectg.geyserhub.module.menu;

import edu.umd.cs.findbugs.annotations.NonNull;
import org.geysermc.cumulus.component.ButtonComponent;
import org.geysermc.cumulus.util.FormImage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Button {

    // base requirement for ButtonComponent
    @Nonnull private String text;
    @Nullable private FormImage image;

    // Everything extra
    @Nonnull private List<String> commands = Collections.emptyList();
    @Nullable private String server;

    /**
     * Create a button.
     * @param text the text of the button
     */
    public Button(@Nonnull String text) {
        this.text = Objects.requireNonNull(text);
    }

    /**
     * Copy constructor
     * @param button The button to make a copy of
     */
    public Button(@Nonnull Button button) {
        this.text = button.text;
        this.image = button.image;
        this.commands = button.getCommands(); // lists are mutable, everything else here isn't
        this.server = button.server;
    }

    /**
     * Set the text of the button.
     * @param text the new text
     * @return the same Button instance
     */
    public Button setText(@Nonnull String text) {
        this.text = Objects.requireNonNull(text);
        return this;
    }

    /**
     * Set the image of the button.
     * @param image the image
     * @return the same Button instance
     */
    public Button setImage(@Nullable FormImage image) {
        this.image = image;
        return this;
    }

    /**
     * set the commands list.
     * @param commands the commands list, which can be empty.
     * @return the same Button instance
     */
    public Button setCommands(@Nonnull List<String> commands) {
        Objects.requireNonNull(commands);
        this.commands = new ArrayList<>(commands);
        return this;
    }

    /**
     * Set the server name.
     * @param server the server name
     * @return the same Button instance
     */
    public Button setServer(@Nullable String server) {
        this.server = server;
        return this;
    }

    /**
     * Get the button component based off the text and image off the Button.
     * @return the button component
     */
    @NonNull
    public ButtonComponent getButtonComponent() {
        return ButtonComponent.of(text, image); //both are immutable
    }

    @Nonnull
    public String getText() {
        return this.text; // Strings are immutable
    }

    @Nullable
    public FormImage getImage() {
        return this.image; // Form image is immutable
    }

    /**
     * Get the commands that should be executed when this button is pressed
     * @return a List of commands, which may be empty.
     */
    @Nonnull
    public List<String> getCommands() {
        return new ArrayList<>(this.commands); // Lists are mutable
    }

    @Nullable
    public String getServer() {
        return this.server; // Strings are immutable
    }
}