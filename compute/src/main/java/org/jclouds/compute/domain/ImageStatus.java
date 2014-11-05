package org.jclouds.compute.domain;

public enum ImageStatus {
	/**
	 * The image is in transition
	 */
	PENDING,
	/**
	 * The image is visible, and in the process of being deleted.
	 */
	DELETED,
	/**
	 * The image is available.
	 */
	AVAILABLE,
	/**
	 * There is an error on the image
	 */
	ERROR,
	/**
	 * The state of the image is unrecognized.
	 */
	UNRECOGNIZED;

}