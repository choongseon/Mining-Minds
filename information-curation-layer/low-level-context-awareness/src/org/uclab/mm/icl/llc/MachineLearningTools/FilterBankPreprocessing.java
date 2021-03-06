/*
Copyright [2016] [Jae Hun, Bang]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package org.uclab.mm.icl.llc.MachineLearningTools;

import java.io.IOException;
import java.util.Vector;

import javax.sound.sampled.AudioInputStream;

import org.uclab.mm.icl.llc.AER.jh.ConvertAudioData;
import org.uclab.mm.icl.llc.AER.jh.TransMFCC;
import org.uclab.mm.icl.llc.AER.jh.jAudioPreProcessing;

import mm.icl.llc.MachineLearningTools.Preprocessing;


/***
 * This class extract computable data with Filter-Bank Algorithms such as LPC, MFCC, Spectrums
 * @author Bang Gae
 *
 */
public class FilterBankPreprocessing extends Preprocessing {
	TransMFCC tmfcc = new TransMFCC();
	jAudioPreProcessing jap = new jAudioPreProcessing();
	ConvertAudioData cad = new ConvertAudioData();
	/***
	 * Extract Power Spectrum by jAudio
	 * @param ais
	 * @return double[]
	 * @throws Exception
	 */
	
	public double[] getPowerSpectrum(AudioInputStream ais) throws Exception {
		double[] result = jap.getPowerSpectrum(ais);
		return result;
	}
	/***
	 * Extract LPC by jAudio
	 * @param ais
	 * @return double[]
	 * @throws Exception
	 */
	

	public double[] getLPC(AudioInputStream ais) throws Exception {
		double[] result = jap.getLPC(ais);
		return result;
	}
	/***
	 * Extract Magnitude Spectrum by jAudio
	 * @param ais
	 * @return double[]
	 * @throws Exception
	 */
	

	public double[] getMagnitudeSpectrum(AudioInputStream ais) throws Exception {
		double[] result = jap.getMagnitudeSpectrum(ais);
		return result;
	}
	/***
	 * Extract Real Value by jAudio
	 * @param ais
	 * @return double[]
	 * @throws Exception
	 */

	public double[] getRealValue(AudioInputStream ais) throws Exception {
		double[] result = jap.getRealValue(ais);
		return result;
	}
	/**
	 * Extract MFCC by Comirva
	 * @param ais
	 * @return double[][]
	 * @throws IOException
	 */
	public double[][] getMfcc(AudioInputStream ais) throws IOException{
		Vector<double[]> mfcc = tmfcc.getMFCC(ais, 1024, 14, true);
		double[][] result = tmfcc.getSingleFileFeatures(mfcc);
		return result;
	}
	/**
	 * No Define
	 */

	@Override
	public Object preprocessing(Object input) {
		// TODO Auto-generated method stub
		return null;
	}

}
