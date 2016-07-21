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

package com.alee.managers.icon.data;

import com.alee.extended.svg.SvgIcon;
import com.kitfox.svg.SVGElement;

import java.util.List;

/**
 * Base class for any attribute adjustments for {@link SvgIcon}.
 *
 * @author Mikle Garin
 */

public abstract class SvgAttributeAdjustment extends SvgAdjustment
{
    @Override
    protected void apply ( final SvgIcon icon, final List<SVGElement> elements )
    {
        final String attribute = getAttribute ( icon );
        if ( attribute != null )
        {
            final String value = getValue ( icon );
            if ( value != null )
            {
                for ( final SVGElement element : elements )
                {
                    icon.setAttribute ( element, attribute, value );
                }
            }
        }
    }

    /**
     * Returns SVG element attribute to adjust.
     *
     * @param icon icon to adjust
     * @return SVG element attribute to adjust
     */
    protected abstract String getAttribute ( SvgIcon icon );

    /**
     * Returns SVG element value to apply.
     *
     * @param icon icon to adjust
     * @return SVG element value to apply
     */
    protected abstract String getValue ( SvgIcon icon );
}