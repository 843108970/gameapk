package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.LinearLayout;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MenuItemImpl implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private static String sDeleteShortcutLabel;
    private static String sEnterShortcutLabel;
    private static String sPrependShortcutLabel;
    private static String sSpaceShortcutLabel;
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private int mFlags = 16;
    private final int mGroup;
    private boolean mHasIconTint = false;
    private boolean mHasIconTintMode = false;
    private Drawable mIconDrawable;
    private int mIconResId = 0;
    private ColorStateList mIconTintList = null;
    private PorterDuff.Mode mIconTintMode = null;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded = false;
    private Runnable mItemCallback;
    MenuBuilder mMenu;
    private ContextMenu.ContextMenuInfo mMenuInfo;
    private boolean mNeedToApplyIconTint = false;
    private MenuItem.OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers = 4096;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers = 4096;
    private int mShowAsAction = 0;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.mMenu = menuBuilder;
        this.mId = i2;
        this.mGroup = i;
        this.mCategoryOrder = i3;
        this.mOrdering = i4;
        this.mTitle = charSequence;
        this.mShowAsAction = i5;
    }

    private Drawable applyIconTintIfNecessary(Drawable drawable) {
        if (drawable != null && this.mNeedToApplyIconTint && (this.mHasIconTint || this.mHasIconTintMode)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (this.mHasIconTint) {
                DrawableCompat.setTintList(drawable, this.mIconTintList);
            }
            if (this.mHasIconTintMode) {
                DrawableCompat.setTintMode(drawable, this.mIconTintMode);
            }
            this.mNeedToApplyIconTint = false;
        }
        return drawable;
    }

    public final void actionFormatChanged() {
        this.mMenu.onItemActionRequestChanged(this);
    }

    public final boolean collapseActionView() {
        if ((this.mShowAsAction & 8) == 0) {
            return false;
        }
        if (this.mActionView == null) {
            return true;
        }
        if (this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.mMenu.collapseItemActionView(this);
        }
        return false;
    }

    public final boolean expandActionView() {
        if (!hasCollapsibleActionView()) {
            return false;
        }
        if (this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionExpand(this)) {
            return this.mMenu.expandItemActionView(this);
        }
        return false;
    }

    public final android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final View getActionView() {
        if (this.mActionView != null) {
            return this.mActionView;
        }
        if (this.mActionProvider == null) {
            return null;
        }
        this.mActionView = this.mActionProvider.onCreateActionView(this);
        return this.mActionView;
    }

    public final int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    public final char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    /* access modifiers changed from: package-private */
    public final Runnable getCallback() {
        return this.mItemCallback;
    }

    public final CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public final int getGroupId() {
        return this.mGroup;
    }

    public final Drawable getIcon() {
        Drawable drawable;
        if (this.mIconDrawable != null) {
            drawable = this.mIconDrawable;
        } else if (this.mIconResId == 0) {
            return null;
        } else {
            drawable = AppCompatResources.getDrawable(this.mMenu.getContext(), this.mIconResId);
            this.mIconResId = 0;
            this.mIconDrawable = drawable;
        }
        return applyIconTintIfNecessary(drawable);
    }

    public final ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    public final PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    public final Intent getIntent() {
        return this.mIntent;
    }

    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.mId;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }

    public final int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    public final char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    public final int getOrder() {
        return this.mCategoryOrder;
    }

    public final int getOrdering() {
        return this.mOrdering;
    }

    /* access modifiers changed from: package-private */
    public final char getShortcut() {
        return this.mMenu.isQwertyMode() ? this.mShortcutAlphabeticChar : this.mShortcutNumericChar;
    }

    /* access modifiers changed from: package-private */
    public final String getShortcutLabel() {
        String str;
        char shortcut = getShortcut();
        if (shortcut == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(sPrependShortcutLabel);
        if (shortcut == 8) {
            str = sDeleteShortcutLabel;
        } else if (shortcut == 10) {
            str = sEnterShortcutLabel;
        } else if (shortcut != ' ') {
            sb.append(shortcut);
            return sb.toString();
        } else {
            str = sSpaceShortcutLabel;
        }
        sb.append(str);
        return sb.toString();
    }

    public final SubMenu getSubMenu() {
        return this.mSubMenu;
    }

    public final ActionProvider getSupportActionProvider() {
        return this.mActionProvider;
    }

    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.mTitle;
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed != null ? this.mTitleCondensed : this.mTitle;
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    /* access modifiers changed from: package-private */
    public final CharSequence getTitleForItemView(MenuView.ItemView itemView) {
        return (itemView == null || !itemView.prefersCondensedTitle()) ? getTitle() : getTitleCondensed();
    }

    public final CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public final boolean hasCollapsibleActionView() {
        if ((this.mShowAsAction & 8) != 0) {
            if (this.mActionView == null && this.mActionProvider != null) {
                this.mActionView = this.mActionProvider.onCreateActionView(this);
            }
            if (this.mActionView != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasSubMenu() {
        return this.mSubMenu != null;
    }

    public final boolean invoke() {
        if ((this.mClickListener != null && this.mClickListener.onMenuItemClick(this)) || this.mMenu.dispatchMenuItemSelected(this.mMenu, this)) {
            return true;
        }
        if (this.mItemCallback != null) {
            this.mItemCallback.run();
            return true;
        }
        if (this.mIntent != null) {
            try {
                this.mMenu.getContext().startActivity(this.mIntent);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e(TAG, "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.mActionProvider != null && this.mActionProvider.onPerformDefaultAction();
    }

    public final boolean isActionButton() {
        return (this.mFlags & 32) == 32;
    }

    public final boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }

    public final boolean isCheckable() {
        return (this.mFlags & 1) == 1;
    }

    public final boolean isChecked() {
        return (this.mFlags & 2) == 2;
    }

    public final boolean isEnabled() {
        return (this.mFlags & 16) != 0;
    }

    public final boolean isExclusiveCheckable() {
        return (this.mFlags & 4) != 0;
    }

    public final boolean isVisible() {
        return (this.mActionProvider == null || !this.mActionProvider.overridesItemVisibility()) ? (this.mFlags & 8) == 0 : (this.mFlags & 8) == 0 && this.mActionProvider.isVisible();
    }

    public final boolean requestsActionButton() {
        return (this.mShowAsAction & 1) == 1;
    }

    public final boolean requiresActionButton() {
        return (this.mShowAsAction & 2) == 2;
    }

    public final MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final SupportMenuItem setActionView(int i) {
        Context context = this.mMenu.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public final SupportMenuItem setActionView(View view) {
        this.mActionView = view;
        this.mActionProvider = null;
        if (view != null && view.getId() == -1 && this.mId > 0) {
            view.setId(this.mId);
        }
        this.mMenu.onItemActionRequestChanged(this);
        return this;
    }

    public final void setActionViewExpanded(boolean z) {
        this.mIsActionViewExpanded = z;
        this.mMenu.onItemsChanged(false);
    }

    public final MenuItem setAlphabeticShortcut(char c2) {
        if (this.mShortcutAlphabeticChar == c2) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c2, int i) {
        if (this.mShortcutAlphabeticChar == c2 && this.mShortcutAlphabeticModifiers == i) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setCallback(Runnable runnable) {
        this.mItemCallback = runnable;
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        int i = this.mFlags;
        this.mFlags = z | (this.mFlags & true) ? 1 : 0;
        if (i != this.mFlags) {
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.mFlags & 4) != 0) {
            this.mMenu.setExclusiveItemChecked(this);
            return this;
        }
        setCheckedInt(z);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void setCheckedInt(boolean z) {
        int i = this.mFlags;
        this.mFlags = (z ? 2 : 0) | (this.mFlags & -3);
        if (i != this.mFlags) {
            this.mMenu.onItemsChanged(false);
        }
    }

    public final SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        this.mFlags = z ? this.mFlags | 16 : this.mFlags & -17;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final void setExclusiveCheckable(boolean z) {
        this.mFlags = (z ? 4 : 0) | (this.mFlags & -5);
    }

    public final MenuItem setIcon(int i) {
        this.mIconDrawable = null;
        this.mIconResId = i;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.mIconResId = 0;
        this.mIconDrawable = drawable;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.mIconTintList = colorStateList;
        this.mHasIconTint = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mIconTintMode = mode;
        this.mHasIconTintMode = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public final void setIsActionButton(boolean z) {
        this.mFlags = z ? this.mFlags | 32 : this.mFlags & -33;
    }

    /* access modifiers changed from: package-private */
    public final void setMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mMenuInfo = contextMenuInfo;
    }

    public final MenuItem setNumericShortcut(char c2) {
        if (this.mShortcutNumericChar == c2) {
            return this;
        }
        this.mShortcutNumericChar = c2;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setNumericShortcut(char c2, int i) {
        if (this.mShortcutNumericChar == c2 && this.mShortcutNumericModifiers == i) {
            return this;
        }
        this.mShortcutNumericChar = c2;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.mOnActionExpandListener = onActionExpandListener;
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mClickListener = onMenuItemClickListener;
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3) {
        this.mShortcutNumericChar = c2;
        this.mShortcutAlphabeticChar = Character.toLowerCase(c3);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.mShortcutNumericChar = c2;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i);
        this.mShortcutAlphabeticChar = Character.toLowerCase(c3);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i2);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.mShowAsAction = i;
                this.mMenu.onItemActionRequestChanged(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public final SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public final void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.mSubMenu = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    public final SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        if (this.mActionProvider != null) {
            this.mActionProvider.reset();
        }
        this.mActionView = null;
        this.mActionProvider = actionProvider;
        this.mMenu.onItemsChanged(true);
        if (this.mActionProvider != null) {
            this.mActionProvider.setVisibilityListener(new ActionProvider.VisibilityListener() {
                public void onActionProviderVisibilityChanged(boolean z) {
                    MenuItemImpl.this.mMenu.onItemVisibleChanged(MenuItemImpl.this);
                }
            });
        }
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle((CharSequence) this.mMenu.getContext().getString(i));
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.mMenu.onItemsChanged(false);
        if (this.mSubMenu != null) {
            this.mSubMenu.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mTitleCondensed = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        if (setVisibleInt(z)) {
            this.mMenu.onItemVisibleChanged(this);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public final boolean setVisibleInt(boolean z) {
        int i = this.mFlags;
        this.mFlags = (z ? 0 : 8) | (this.mFlags & -9);
        return i != this.mFlags;
    }

    public final boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }

    /* access modifiers changed from: package-private */
    public final boolean shouldShowShortcut() {
        return this.mMenu.isShortcutsVisible() && getShortcut() != 0;
    }

    public final boolean showsTextAsAction() {
        return (this.mShowAsAction & 4) == 4;
    }

    public final String toString() {
        if (this.mTitle != null) {
            return this.mTitle.toString();
        }
        return null;
    }
}
