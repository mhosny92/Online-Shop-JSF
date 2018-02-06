package com.onlineshop.base;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@SuppressWarnings("serial")
public abstract class ViewImage implements Serializable{

	protected enum type{thumb, image};
	
	
	protected StreamedContent thumb;
	protected StreamedContent image;
	
	protected abstract StreamedContent getImageContent(type t) throws Exception;
	
	/**
	 * @return the image
	 * @throws Exception 
	 */
	public StreamedContent getImage() throws Exception {
		if (FacesContext.getCurrentInstance().getCurrentPhaseId() == PhaseId.RENDER_RESPONSE){
			return new DefaultStreamedContent();
		}
		return getImageContent(type.image);
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(StreamedContent image) {
		this.image = image;
	}
	/**
	 * @return the thumb
	 * @throws Exception 
	 */
	public StreamedContent getThumb() throws Exception {
		if (FacesContext.getCurrentInstance().getCurrentPhaseId() == PhaseId.RENDER_RESPONSE){
			return new DefaultStreamedContent();
		}
		return getImageContent(type.thumb);
	}
	/**
	 * @param thumb the thumb to set
	 */
	public void setThumb(StreamedContent thumb) {
		this.thumb = thumb;
	}
	
	
}
