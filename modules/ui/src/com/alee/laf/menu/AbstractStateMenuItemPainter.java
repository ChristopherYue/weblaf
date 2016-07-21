/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.laf.menu;

import com.alee.laf.checkbox.AbstractStateButtonPainter;
import com.alee.painter.decoration.DecorationState;
import com.alee.painter.decoration.IDecoration;

import javax.swing.*;
import javax.swing.plaf.MenuItemUI;
import java.util.List;

/**
 * Abstract painter for state menu item components.
 *
 * @param <E> component type
 * @param <U> component UI type
 * @param <D> decoration type
 * @author Alexandr Zernov
 */

public abstract class AbstractStateMenuItemPainter<E extends JMenuItem, U extends MenuItemUI, D extends IDecoration<E, D>>
        extends AbstractStateButtonPainter<E, U, D> implements IAbstractMenuItemPainter<E, U>
{
    /**
     * Button model change listener.
     */
    protected MenuItemChangeListener buttonModelChangeListener;

    @Override
    public void install ( final E c, final U ui )
    {
        super.install ( c, ui );

        // Installing corner updater
        buttonModelChangeListener = MenuItemChangeListener.install ( component );
    }

    @Override
    public void uninstall ( final E c, final U ui )
    {
        // Uninstalling corner updater
        buttonModelChangeListener = MenuItemChangeListener.uninstall ( buttonModelChangeListener, component );

        super.uninstall ( c, ui );
    }

    @Override
    protected List<String> getDecorationStates ()
    {
        final List<String> states = super.getDecorationStates ();
        if ( component.isSelected () )
        {
            states.add ( DecorationState.checked );
        }
        return states;
    }

    @Override
    protected boolean isSelected ()
    {
        return component.isEnabled () && component.getModel ().isArmed ();
    }
}