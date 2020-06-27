/**
 * 
 */
package com.ashwani.slambook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwani.slambook.entity.Slam;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 26-Jun-2020
 *
*/
public interface SlamRepository extends JpaRepository<Slam, Long> {

}
