package android.lib.contextmenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

final class MockMenu implements Menu {
    private final Context                context;
    private final Map<Integer, MenuItem> items     = new TreeMap<Integer, MenuItem>();
    private final List<MenuItem>         orderings = new ArrayList<MenuItem>();
    private final Set<MenuItem>          sortings  = new TreeSet<MenuItem>();

    public MockMenu(final Context context) {
        this.context = context;
    }

    @Override
    public MenuItem add(final CharSequence title) {
        final MockMenuItem item = new MockMenuItem(this.context);

        item.setTitle(title);

        this.items.put(Integer.valueOf(item.getItemId()), item);
        this.orderings.add(item);
        this.sortings.add(item);

        return item;
    }

    @Override
    public MenuItem add(final int titleRes) {
        final MockMenuItem item = new MockMenuItem(this.context);

        item.setTitle(titleRes);

        this.items.put(Integer.valueOf(item.getItemId()), item);
        this.orderings.add(item);
        this.sortings.add(item);

        return item;
    }

    @Override
    public MenuItem add(final int groupId, final int itemId, final int order, final CharSequence title) {
        final MockMenuItem item = new MockMenuItem(this.context);

        item.setTitle(title);
        item.setGroupId(groupId);
        item.setItemId(itemId);
        item.setOrder(order);

        this.items.put(Integer.valueOf(itemId), item);
        this.orderings.add(item);
        this.sortings.add(item);

        return item;
    }

    @Override
    public MenuItem add(final int groupId, final int itemId, final int order, final int titleRes) {
        final MockMenuItem item = new MockMenuItem(this.context);

        item.setTitle(titleRes);
        item.setGroupId(groupId);
        item.setItemId(itemId);
        item.setOrder(order);

        this.items.put(Integer.valueOf(itemId), item);
        this.orderings.add(item);
        this.sortings.add(item);

        return item;
    }

    @Override
    public int addIntentOptions(final int groupId, final int itemId, final int order, final ComponentName caller, final Intent[] specifics, final Intent intent, final int flags, final MenuItem[] outSpecificItems) {
        return 0;
    }

    @Override
    public SubMenu addSubMenu(final CharSequence title) {
        return null;
    }

    @Override
    public SubMenu addSubMenu(final int titleRes) {
        return null;
    }

    @Override
    public SubMenu addSubMenu(final int groupId, final int itemId, final int order, final CharSequence title) {
        return null;
    }

    @Override
    public SubMenu addSubMenu(final int groupId, final int itemId, final int order, final int titleRes) {
        return null;
    }

    @Override
    public void clear() {
        this.items.clear();
        this.orderings.clear();
        this.sortings.clear();
    }

    @Override
    public void close() {
    }

    @Override
    public MenuItem findItem(final int id) {
        return this.items.get(Integer.valueOf(id));
    }

    @Override
    public MenuItem getItem(final int index) {
        return this.orderings.get(index);
    }

    @Override
    public boolean hasVisibleItems() {
        for (final MenuItem item : this.orderings) {
            if (item.isVisible()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isShortcutKey(final int keyCode, final KeyEvent event) {
        return false;
    }

    @Override
    public boolean performShortcut(final int keyCode, final KeyEvent event, final int flags) {
        return false;
    }

    @Override
    public boolean performIdentifierAction(final int id, final int flags) {
        return false;
    }

    @Override
    public void removeGroup(final int groupId) {
        final List<MenuItem> removes = new ArrayList<MenuItem>();

        for (final MenuItem item : this.orderings) {
            if (item.getGroupId() == groupId) {
                removes.add(item);
            }
        }

        for (final MenuItem item : removes) {
            this.items.remove(Integer.valueOf(item.getItemId()));
        }

        this.orderings.removeAll(removes);
        this.sortings.removeAll(removes);
    }

    @Override
    public void removeItem(final int id) {
        final MenuItem item = this.items.remove(Integer.valueOf(id));

        this.orderings.remove(item);
        this.sortings.remove(item);
    }

    @Override
    public void setGroupCheckable(final int group, final boolean checkable, final boolean exclusive) {
        if (exclusive) {
            for (final MenuItem item : this.orderings) {
                item.setChecked(false);
            }
        }

        for (final MenuItem item : this.orderings) {
            item.setCheckable(checkable);
        }
    }

    @Override
    public void setGroupEnabled(final int group, final boolean enabled) {
        for (final MenuItem item : this.orderings) {
            if (item.getGroupId() == group) {
                item.setEnabled(enabled);
            }
        }
    }

    @Override
    public void setGroupVisible(final int group, final boolean visible) {
        for (final MenuItem item : this.orderings) {
            if (item.getGroupId() == group) {
                item.setVisible(visible);
            }
        }
    }

    @Override
    public void setQwertyMode(final boolean isQwerty) {
    }

    @Override
    public int size() {
        return this.items.size();
    }
}
