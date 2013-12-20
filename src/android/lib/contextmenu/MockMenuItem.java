package android.lib.contextmenu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.SubMenu;

final class MockMenuItem implements MenuItem, Comparable<MenuItem> {
    private final Context context;

    private char                    alphaChar;
    private char                    numericChar;
    private int                     groupId;
    private Drawable                icon;
    private Intent                  intent;
    private int                     itemId;
    private int                     order;
    private CharSequence            title;
    private CharSequence            titleCondense;
    private boolean                 checkable;
    private boolean                 checked;
    private boolean                 enabled;
    private boolean                 visible;
    private OnMenuItemClickListener menuItemClickListener;

    public MockMenuItem(final Context context) {
        this.context = context;
    }

    @Override
    public MenuItem setShortcut(final char numericChar, final char alphaChar) {
        this.numericChar = numericChar;
        this.alphaChar   = alphaChar;

        return this;
    }

    @Override
    public char getAlphabeticShortcut() {
        return this.alphaChar;
    }

    @Override
    public MenuItem setAlphabeticShortcut(final char shortcut) {
        this.alphaChar = shortcut;

        return this;
    }

    @Override
    public char getNumericShortcut() {
        return this.numericChar;
    }

    @Override
    public MenuItem setNumericShortcut(final char numericChar) {
        this.numericChar = numericChar;

        return this;
    }

    @Override
    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(final int groupId) {
        this.groupId = groupId;
    }

    @Override
    public Drawable getIcon() {
        return this.icon;
    }

    @Override
    public MenuItem setIcon(final int icon) {
        this.icon = this.context.getResources().getDrawable(icon);

        return this;
    }

    @Override
    public MenuItem setIcon(final Drawable icon) {
        this.icon = icon;

        return this;
    }

    @Override
    public Intent getIntent() {
        return this.intent;
    }

    @Override
    public MenuItem setIntent(final Intent intent) {
        this.intent = intent;

        return this;
    }

    @Override
    public int getItemId() {
        return this.itemId;
    }

    public void setItemId(final int itemId) {
        this.itemId = itemId;
    }

    @Override
    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    public void setOrder(final int order) {
        this.order = order;
    }

    @Override
    public SubMenu getSubMenu() {
        return null;
    }

    @Override
    public CharSequence getTitle() {
        return this.title;
    }

    @Override
    public MenuItem setTitle(final int title) {
        this.title = this.context.getText(title);

        return this;
    }

    @Override
    public MenuItem setTitle(final CharSequence title) {
        this.title = title;

        return this;
    }

    @Override
    public CharSequence getTitleCondensed() {
        return this.titleCondense;
    }

    @Override
    public MenuItem setTitleCondensed(final CharSequence title) {
        this.titleCondense = title;

        return this;
    }

    @Override
    public boolean hasSubMenu() {
        return false;
    }

    @Override
    public boolean isCheckable() {
        return this.checkable;
    }

    @Override
    public MenuItem setCheckable(final boolean checkable) {
        this.checkable = checkable;

        return this;
    }

    @Override
    public boolean isChecked() {
        return this.checked;
    }

    @Override
    public MenuItem setChecked(final boolean checked) {
        this.checked = checked;

        return this;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public MenuItem setEnabled(final boolean enabled) {
        this.enabled = enabled;

        return this;
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    @Override
    public MenuItem setVisible(final boolean visible) {
        this.visible = visible;

        return this;
    }

    public OnMenuItemClickListener getOnMenuItemClickListener() {
        return this.menuItemClickListener;
    }

    @Override
    public MenuItem setOnMenuItemClickListener(final OnMenuItemClickListener menuItemClickListener) {
        this.menuItemClickListener = menuItemClickListener;

        return this;
    }

    @Override
    public int compareTo(final MenuItem another) {
        return this.getGroupId() - another.getGroupId();
    }
}
