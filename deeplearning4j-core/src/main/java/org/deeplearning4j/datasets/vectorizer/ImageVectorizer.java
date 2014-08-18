package org.deeplearning4j.datasets.vectorizer;

import java.io.File;

import org.deeplearning4j.linalg.api.ndarray.INDArray;
import org.deeplearning4j.linalg.dataset.DataSet;
import org.deeplearning4j.linalg.util.FeatureUtil;
import org.deeplearning4j.util.ImageLoader;

/**
 * An image vectorizer takes an input image (RGB) and
 * transforms it in to a data applyTransformToDestination
 * @author Adam Gibson
 *
 */
public class ImageVectorizer implements Vectorizer {

	private File image;
	private ImageLoader loader = new ImageLoader();
	private boolean binarize;
	private boolean normalize;
	private int label;
	private int numLabels;
	private int threshold = 30;
	
	/**
	 * Baseline knowledge needed for the vectorizer
	 * @param image the input image to convert
	 * @param numLabels the number of labels
	 * @param label the label of this image
	 */
	public ImageVectorizer(File image,int numLabels,int label) {
		super();
		this.image = image;
		this.numLabels = numLabels;
		this.label = label;
	}


	/**
	 * Binarize the data based on the threshold (anything < threshold is zero)
	 * This  is used for making the image brightness agnostic.
	 * @return builder pattern
	 */
	public ImageVectorizer binarize(int threshold) {
		this.binarize = true;
		this.normalize = false;
		return this;
	}
	
	/**
	 * Binarize the data based on the threshold (anything < threshold is zero)
	 * This  is used for making the image brightness agnostic.
	 * Equivalent to calling (binarze(30))
	 * @return builder pattern
	 */
	public ImageVectorizer binarize() {
		return binarize(30);
	}

	/**
	 * Normalize the input image by row sums
	 * @return builder pattern
	 */
	public ImageVectorizer normalize() {
		this.binarize = false;
		this.normalize = true;
		return this;
	}


	@Override
	public DataSet vectorize() {
		try {
			INDArray d = loader.asMatrix(image);
			INDArray label2 = FeatureUtil.toOutcomeVector(label, numLabels);
			if(normalize) {
				d = d.div(255);
			}
			else if(binarize) {
				for(int i = 0; i < d.length(); i++) {
					double curr = (double) d.getScalar(i).element();
					if(curr > threshold) {
						d.putScalar(i, 1);
					}
					else 
						d.putScalar(i, 0);


				}
			}


			return new DataSet(d,label2);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}


}
