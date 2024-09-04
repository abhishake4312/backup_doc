
package com.boeing.ps.innovationvenue.common.exception;

/**
 * @author hs645e
 *
 */
public class ApplicationException extends Exception {

	/**
	 * Variable declared to hold serial version UID
	 */
	private static final long serialVersionUID = -5052866646300396877L;

	/**
	 * Variable declared to hold the key.
	 */
	private ExceptionKey key;

	/**
	 * Variable declared to hold the detail of the exception
	 */
	private String additionalDetail;

	/**
	 * Constructor used to throw the exception.
	 * 
	 * @param t - Throwable
	 */
	public ApplicationException(Throwable t) {
		super(t);
	}

	/**
	 * Constructor used to throw the exception.
	 * 
	 * @param strException - Exception.
	 */
	public ApplicationException(String strException) {
		super(strException);
	}

	/**
	 * Constructor used to throw the particular exception.
	 * 
	 * @param key - ExceptionKey
	 */
	public ApplicationException(ExceptionKey key) {
		this.setKey(key);
	}

	/**
	 * Constructor used to throw the exception and its details.
	 * 
	 * @param key              - ExceptionKey
	 * @param additionalDetail - String
	 */
	public ApplicationException(ExceptionKey key, String additionalDetail) {
		this.setKey(key);
		this.setAdditionalDetail(additionalDetail);
	}

	/**
	 * Constructor used to throw the exception.
	 * 
	 * @param key - ExceptionKey
	 * @param t   - Throwable
	 */
	public ApplicationException(ExceptionKey key, Throwable t) {
		super(key.getValue(), t);
	}

	/**
	 * Constructor used to throw the exception and its details.
	 * 
	 * @param key              - ExceptionKey
	 * @param t                - Throwable
	 * @param additionalDetail - String
	 */
	public ApplicationException(ExceptionKey key, Throwable t, String additionalDetail) {
		super(key.getValue(), t);
		this.setAdditionalDetail(additionalDetail);
	}

	/**
	 * Method used to get the description of the message.
	 * 
	 * @return message - String
	 */
	public final String getMessage() {
		super.getMessage();
		String msg = this.getKey() == null ? "" : this.getKey().getValue();
		StringBuffer message = new StringBuffer(msg);
		if (this.getAdditionalDetail() != null) {
			message = message.append('\n').append(this.getAdditionalDetail());
		}
		return message.toString();
	}

	/**
	 * Getter for key.
	 * 
	 * @return - key
	 */
	public final ExceptionKey getKey() {
		return key;
	}

	/**
	 * Setter for key.
	 * 
	 * @param key - key
	 */
	public final void setKey(ExceptionKey key) {
		this.key = key;
	}

	/**
	 * Getter for additional details.
	 * 
	 * @return - additionalDetail
	 */
	public final String getAdditionalDetail() {
		return additionalDetail;
	}

	/**
	 * Setter for additionalDetail.
	 * 
	 * @param additionalDetail - additionalDetail
	 */
	public final void setAdditionalDetail(String additionalDetail) {
		this.additionalDetail = additionalDetail;
	}

	/**
	 * This class holds the exception keys.
	 * 
	 * @author madhankumar.kr
	 *
	 */
	public static enum ExceptionKey {
		/**
		 * SQL exception is thrown
		 */
		SQLException("D001", "SQL Exception"),
		/**
		 * ResourceException is thrown
		 */
		ResourceException("D002", "Resource Exception"),
		/**
		 * DataException is thrown
		 */
		DataException("D003", "Data Exception"),
		/**
		 * BusinessException is thrown
		 */
		BusinessException("S001", "Business Exception");

		/**
		 * Variable declared to hold the key.
		 */
		private String key;
		/**
		 * Variable declared to hold the message of the exception.
		 */
		private String message;

		/**
		 * Constructor used to get the message and its key
		 * 
		 * @param key     - String
		 * @param message - String
		 */
		private ExceptionKey(String key, String message) {
			this.key = key;
			this.message = message;
		}

		/**
		 * This method returns the exception key with message.
		 * 
		 * @return - exception message.
		 */
		public String getValue() {
			return this.key + " - " + this.message;
		}
	}
}
