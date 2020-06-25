/**
 * 
 */
package com.ashwani.slambook.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 25-Jun-2020
 *
*/

public interface LoggingService {
    
    void logRequest(HttpServletRequest httpServletRequest, Object body);
    
    void logResponse(HttpServletRequest httpServletRequest, 
                     HttpServletResponse httpServletResponse, 
                     Object body);
}
