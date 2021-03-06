/* Yougi is a web application conceived to manage user groups or
 * communities focused on a certain domain of knowledge, whose members are
 * constantly sharing information and participating in social and educational
 * events. Copyright (C) 2011 Hildeberto Mendonça.
 *
 * This application is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation; either version 2.1 of the License, or (at your
 * option) any later version.
 *
 * This application is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * There is a full copy of the GNU Lesser General Public License along with
 * this library. Look for the file license.txt at the root level. If you do not
 * find it, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA 02111-1307 USA.
 * */
package org.cejug.yougi.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.cejug.yougi.entity.Gender;
import org.cejug.yougi.util.ResourceBundleHelper;

/**
 * @author Hildeberto Mendonca - http://www.hildeberto.com
 */
@FacesConverter(value="GenderToString")
public class GenderToString implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if("MALE".equals(value)) {
            return Gender.MALE;
        }
        else {
            return Gender.FEMALE;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Gender gender = (Gender) value;
        String genderStr = null;
        switch(gender) {
            case FEMALE:
                genderStr = ResourceBundleHelper.INSTANCE.getMessage("female");
                break;
            case MALE:
                genderStr = ResourceBundleHelper.INSTANCE.getMessage("male");
                break;
        }
        return genderStr;
    }
}