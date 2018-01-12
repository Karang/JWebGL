/*
 * Copyright 2018 Arthur Hennequin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
Original LICENSE of gl-matrix.js :

Copyright (c) 2015, Brandon Jones, Colin MacKenzie IV.
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE. */

package fr.karang.jwebgl.glmatrix;

public class Mat4 {

	public float[] m = new float[16];

	/**
	 * 4x4 Matrix
	 * @module mat4
	 */
	public Mat4() {
		m[0] = 1.f;
		m[1] = 0.f;
		m[2] = 0.f;
		m[3] = 0.f;
		m[4] = 0.f;
		m[5] = 1.f;
		m[6] = 0.f;
		m[7] = 0.f;
		m[8] = 0.f;
		m[9] = 0.f;
		m[10] = 1.f;
		m[11] = 0.f;
		m[12] = 0.f;
		m[13] = 0.f;
		m[14] = 0.f;
		m[15] = 1.f;
	}

	/**
	 * Creates a new identity mat4
	 *
	 * @returns {Mat4} a new 4x4 matrix
	 */
	public static Mat4 create() {
		return new Mat4();
	}

	/**
	 * Creates a new Mat4 initialized with values from an existing matrix
	 *
	 * @param {Mat4} a matrix to clone
	 * @returns {Mat4} a new 4x4 matrix
	 */
	public static Mat4 clone(Mat4 a) {
		Mat4 out = new Mat4();
		out.m[0] = a.m[0];
		out.m[1] = a.m[1];
		out.m[2] = a.m[2];
		out.m[3] = a.m[3];
		out.m[4] = a.m[4];
		out.m[5] = a.m[5];
		out.m[6] = a.m[6];
		out.m[7] = a.m[7];
		out.m[8] = a.m[8];
		out.m[9] = a.m[9];
		out.m[10] = a.m[10];
		out.m[11] = a.m[11];
		out.m[12] = a.m[12];
		out.m[13] = a.m[13];
		out.m[14] = a.m[14];
		out.m[15] = a.m[15];
		return out;
	}

	/**
	 * Copy the values from one Mat4 to another
	 *
	 * @param {mat4} out the receiving matrix
	 * @param {mat4} a the source matrix
	 * @returns {mat4} out
	 */
	public static Mat4 copy(Mat4 out, Mat4 a) {
		out.m[0] = a.m[0];
		out.m[1] = a.m[1];
		out.m[2] = a.m[2];
		out.m[3] = a.m[3];
		out.m[4] = a.m[4];
		out.m[5] = a.m[5];
		out.m[6] = a.m[6];
		out.m[7] = a.m[7];
		out.m[8] = a.m[8];
		out.m[9] = a.m[9];
		out.m[10] = a.m[10];
		out.m[11] = a.m[11];
		out.m[12] = a.m[12];
		out.m[13] = a.m[13];
		out.m[14] = a.m[14];
		out.m[15] = a.m[15];
		return out;
	}

	/**
	 * Create a new Mat4 with the given values
	 *
	 * @param {float} m00 Component in column 0, row 0 position (index 0)
	 * @param {float} m01 Component in column 0, row 1 position (index 1)
	 * @param {float} m02 Component in column 0, row 2 position (index 2)
	 * @param {float} m03 Component in column 0, row 3 position (index 3)
	 * @param {float} m10 Component in column 1, row 0 position (index 4)
	 * @param {float} m11 Component in column 1, row 1 position (index 5)
	 * @param {float} m12 Component in column 1, row 2 position (index 6)
	 * @param {float} m13 Component in column 1, row 3 position (index 7)
	 * @param {float} m20 Component in column 2, row 0 position (index 8)
	 * @param {float} m21 Component in column 2, row 1 position (index 9)
	 * @param {float} m22 Component in column 2, row 2 position (index 10)
	 * @param {float} m23 Component in column 2, row 3 position (index 11)
	 * @param {float} m30 Component in column 3, row 0 position (index 12)
	 * @param {float} m31 Component in column 3, row 1 position (index 13)
	 * @param {float} m32 Component in column 3, row 2 position (index 14)
	 * @param {float} m33 Component in column 3, row 3 position (index 15)
	 * @returns {Mat4} A new Mat4
	 */
	public static Mat4 fromValues(
			float m00, float m01, float m02, float m03,
			float m10, float m11, float m12, float m13,
			float m20, float m21, float m22, float m23,
			float m30, float m31, float m32, float m33) {
		Mat4 out = new Mat4();
		out.m[0] = m00;
		out.m[1] = m01;
		out.m[2] = m02;
		out.m[3] = m03;
		out.m[4] = m10;
		out.m[5] = m11;
		out.m[6] = m12;
		out.m[7] = m13;
		out.m[8] = m20;
		out.m[9] = m21;
		out.m[10] = m22;
		out.m[11] = m23;
		out.m[12] = m30;
		out.m[13] = m31;
		out.m[14] = m32;
		out.m[15] = m33;
		return out;
	}

	/**
	 * Set the components of a mat4 to the given values
	 *
	 * @param {Mat4} out the receiving matrix
	 * @param {float} m00 Component in column 0, row 0 position (index 0)
	 * @param {float} m01 Component in column 0, row 1 position (index 1)
	 * @param {float} m02 Component in column 0, row 2 position (index 2)
	 * @param {float} m03 Component in column 0, row 3 position (index 3)
	 * @param {float} m10 Component in column 1, row 0 position (index 4)
	 * @param {float} m11 Component in column 1, row 1 position (index 5)
	 * @param {float} m12 Component in column 1, row 2 position (index 6)
	 * @param {float} m13 Component in column 1, row 3 position (index 7)
	 * @param {float} m20 Component in column 2, row 0 position (index 8)
	 * @param {float} m21 Component in column 2, row 1 position (index 9)
	 * @param {float} m22 Component in column 2, row 2 position (index 10)
	 * @param {float} m23 Component in column 2, row 3 position (index 11)
	 * @param {float} m30 Component in column 3, row 0 position (index 12)
	 * @param {float} m31 Component in column 3, row 1 position (index 13)
	 * @param {float} m32 Component in column 3, row 2 position (index 14)
	 * @param {float} m33 Component in column 3, row 3 position (index 15)
	 * @returns {Mat4} out
	 */
	public static Mat4 set(Mat4 out,
			float m00, float m01, float m02, float m03,
			float m10, float m11, float m12, float m13,
			float m20, float m21, float m22, float m23,
			float m30, float m31, float m32, float m33) {
		out.m[0] = m00;
		out.m[1] = m01;
		out.m[2] = m02;
		out.m[3] = m03;
		out.m[4] = m10;
		out.m[5] = m11;
		out.m[6] = m12;
		out.m[7] = m13;
		out.m[8] = m20;
		out.m[9] = m21;
		out.m[10] = m22;
		out.m[11] = m23;
		out.m[12] = m30;
		out.m[13] = m31;
		out.m[14] = m32;
		out.m[15] = m33;
		return out;
	}

	/**
	 * Set a Mat4 to the identity matrix
	 *
	 * @param {Mat4} out the receiving matrix
	 * @returns {Mat4} out
	 */
	public static Mat4 identity(Mat4 out) {
		out.m[0] = 1.f;
		out.m[1] = 0.f;
		out.m[2] = 0.f;
		out.m[3] = 0.f;
		out.m[4] = 0.f;
		out.m[5] = 1.f;
		out.m[6] = 0.f;
		out.m[7] = 0.f;
		out.m[8] = 0.f;
		out.m[9] = 0.f;
		out.m[10] = 1.f;
		out.m[11] = 0.f;
		out.m[12] = 0.f;
		out.m[13] = 0.f;
		out.m[14] = 0.f;
		out.m[15] = 1.f;
		return out;
	}

	/**
	 * Transpose the values of a Mat4
	 *
	 * @param {Mat4} out the receiving matrix
	 * @param {Mat4} a the source matrix
	 * @returns {Mat4} out
	 */
	public static Mat4 transpose(Mat4 out, Mat4 a) {
		// If we are transposing ourselves we can skip a few steps but have to cache some values
		if (out == a) {
			float a01 = a.m[1], a02 = a.m[2], a03 = a.m[3];
			float a12 = a.m[6], a13 = a.m[7];
			float a23 = a.m[11];

			out.m[1] = a.m[4];
			out.m[2] = a.m[8];
			out.m[3] = a.m[12];
			out.m[4] = a01;
			out.m[6] = a.m[9];
			out.m[7] = a.m[13];
			out.m[8] = a02;
			out.m[9] = a12;
			out.m[11] = a.m[14];
			out.m[12] = a03;
			out.m[13] = a13;
			out.m[14] = a23;
		} else {
			out.m[0] = a.m[0];
			out.m[1] = a.m[4];
			out.m[2] = a.m[8];
			out.m[3] = a.m[12];
			out.m[4] = a.m[1];
			out.m[5] = a.m[5];
			out.m[6] = a.m[9];
			out.m[7] = a.m[13];
			out.m[8] = a.m[2];
			out.m[9] = a.m[6];
			out.m[10] = a.m[10];
			out.m[11] = a.m[14];
			out.m[12] = a.m[3];
			out.m[13] = a.m[7];
			out.m[14] = a.m[11];
			out.m[15] = a.m[15];
		}

		return out;
	}

	/**
	 * Inverts a Mat4
	 *
	 * @param {Mat4} out the receiving matrix
	 * @param {Mat4} a the source matrix
	 * @returns {Mat4} out
	 */
	public static Mat4 invert(Mat4 out, Mat4 a) {
		float a00 = a.m[0], a01 = a.m[1], a02 = a.m[2], a03 = a.m[3];
		float a10 = a.m[4], a11 = a.m[5], a12 = a.m[6], a13 = a.m[7];
		float a20 = a.m[8], a21 = a.m[9], a22 = a.m[10], a23 = a.m[11];
		float a30 = a.m[12], a31 = a.m[13], a32 = a.m[14], a33 = a.m[15];

		float b00 = a00 * a11 - a01 * a10;
		float b01 = a00 * a12 - a02 * a10;
		float b02 = a00 * a13 - a03 * a10;
		float b03 = a01 * a12 - a02 * a11;
		float b04 = a01 * a13 - a03 * a11;
		float b05 = a02 * a13 - a03 * a12;
		float b06 = a20 * a31 - a21 * a30;
		float b07 = a20 * a32 - a22 * a30;
		float b08 = a20 * a33 - a23 * a30;
		float b09 = a21 * a32 - a22 * a31;
		float b10 = a21 * a33 - a23 * a31;
		float b11 = a22 * a33 - a23 * a32;

		// Calculate the determinant
		float det = b00 * b11 - b01 * b10 + b02 * b09 + b03 * b08 - b04 * b07 + b05 * b06;

		if (det == 0.f) {
			return null;
		}
		det = 1.f / det;

		out.m[0] = (a11 * b11 - a12 * b10 + a13 * b09) * det;
		out.m[1] = (a02 * b10 - a01 * b11 - a03 * b09) * det;
		out.m[2] = (a31 * b05 - a32 * b04 + a33 * b03) * det;
		out.m[3] = (a22 * b04 - a21 * b05 - a23 * b03) * det;
		out.m[4] = (a12 * b08 - a10 * b11 - a13 * b07) * det;
		out.m[5] = (a00 * b11 - a02 * b08 + a03 * b07) * det;
		out.m[6] = (a32 * b02 - a30 * b05 - a33 * b01) * det;
		out.m[7] = (a20 * b05 - a22 * b02 + a23 * b01) * det;
		out.m[8] = (a10 * b10 - a11 * b08 + a13 * b06) * det;
		out.m[9] = (a01 * b08 - a00 * b10 - a03 * b06) * det;
		out.m[10] = (a30 * b04 - a31 * b02 + a33 * b00) * det;
		out.m[11] = (a21 * b02 - a20 * b04 - a23 * b00) * det;
		out.m[12] = (a11 * b07 - a10 * b09 - a12 * b06) * det;
		out.m[13] = (a00 * b09 - a01 * b07 + a02 * b06) * det;
		out.m[14] = (a31 * b01 - a30 * b03 - a32 * b00) * det;
		out.m[15] = (a20 * b03 - a21 * b01 + a22 * b00) * det;

		return out;
	}

	/**
	 * Calculates the adjugate of a mat4
	 *
	 * @param {Mat4} out the receiving matrix
	 * @param {Mat4} a the source matrix
	 * @returns {Mat4} out
	 */
	public static Mat4 adjoint(Mat4 out, Mat4 a) {
		float a00 = a.m[0], a01 = a.m[1], a02 = a.m[2], a03 = a.m[3];
		float a10 = a.m[4], a11 = a.m[5], a12 = a.m[6], a13 = a.m[7];
		float a20 = a.m[8], a21 = a.m[9], a22 = a.m[10], a23 = a.m[11];
		float a30 = a.m[12], a31 = a.m[13], a32 = a.m[14], a33 = a.m[15];

		out.m[0]  =  (a11 * (a22 * a33 - a23 * a32) - a21 * (a12 * a33 - a13 * a32) + a31 * (a12 * a23 - a13 * a22));
		out.m[1]  = -(a01 * (a22 * a33 - a23 * a32) - a21 * (a02 * a33 - a03 * a32) + a31 * (a02 * a23 - a03 * a22));
		out.m[2]  =  (a01 * (a12 * a33 - a13 * a32) - a11 * (a02 * a33 - a03 * a32) + a31 * (a02 * a13 - a03 * a12));
		out.m[3]  = -(a01 * (a12 * a23 - a13 * a22) - a11 * (a02 * a23 - a03 * a22) + a21 * (a02 * a13 - a03 * a12));
		out.m[4]  = -(a10 * (a22 * a33 - a23 * a32) - a20 * (a12 * a33 - a13 * a32) + a30 * (a12 * a23 - a13 * a22));
		out.m[5]  =  (a00 * (a22 * a33 - a23 * a32) - a20 * (a02 * a33 - a03 * a32) + a30 * (a02 * a23 - a03 * a22));
		out.m[6]  = -(a00 * (a12 * a33 - a13 * a32) - a10 * (a02 * a33 - a03 * a32) + a30 * (a02 * a13 - a03 * a12));
		out.m[7]  =  (a00 * (a12 * a23 - a13 * a22) - a10 * (a02 * a23 - a03 * a22) + a20 * (a02 * a13 - a03 * a12));
		out.m[8]  =  (a10 * (a21 * a33 - a23 * a31) - a20 * (a11 * a33 - a13 * a31) + a30 * (a11 * a23 - a13 * a21));
		out.m[9]  = -(a00 * (a21 * a33 - a23 * a31) - a20 * (a01 * a33 - a03 * a31) + a30 * (a01 * a23 - a03 * a21));
		out.m[10] =  (a00 * (a11 * a33 - a13 * a31) - a10 * (a01 * a33 - a03 * a31) + a30 * (a01 * a13 - a03 * a11));
		out.m[11] = -(a00 * (a11 * a23 - a13 * a21) - a10 * (a01 * a23 - a03 * a21) + a20 * (a01 * a13 - a03 * a11));
		out.m[12] = -(a10 * (a21 * a32 - a22 * a31) - a20 * (a11 * a32 - a12 * a31) + a30 * (a11 * a22 - a12 * a21));
		out.m[13] =  (a00 * (a21 * a32 - a22 * a31) - a20 * (a01 * a32 - a02 * a31) + a30 * (a01 * a22 - a02 * a21));
		out.m[14] = -(a00 * (a11 * a32 - a12 * a31) - a10 * (a01 * a32 - a02 * a31) + a30 * (a01 * a12 - a02 * a11));
		out.m[15] =  (a00 * (a11 * a22 - a12 * a21) - a10 * (a01 * a22 - a02 * a21) + a20 * (a01 * a12 - a02 * a11));
		return out;
	}

	/**
	 * Calculates the determinant of a Mat4
	 *
	 * @param {Mat4} a the source matrix
	 * @returns {float} determinant of a
	 */
	public static float determinant(Mat4 a) {
		float a00 = a.m[0], a01 = a.m[1], a02 = a.m[2], a03 = a.m[3];
		float a10 = a.m[4], a11 = a.m[5], a12 = a.m[6], a13 = a.m[7];
		float a20 = a.m[8], a21 = a.m[9], a22 = a.m[10], a23 = a.m[11];
		float a30 = a.m[12], a31 = a.m[13], a32 = a.m[14], a33 = a.m[15];

		float b00 = a00 * a11 - a01 * a10;
		float b01 = a00 * a12 - a02 * a10;
		float b02 = a00 * a13 - a03 * a10;
		float b03 = a01 * a12 - a02 * a11;
		float b04 = a01 * a13 - a03 * a11;
		float b05 = a02 * a13 - a03 * a12;
		float b06 = a20 * a31 - a21 * a30;
		float b07 = a20 * a32 - a22 * a30;
		float b08 = a20 * a33 - a23 * a30;
		float b09 = a21 * a32 - a22 * a31;
		float b10 = a21 * a33 - a23 * a31;
		float b11 = a22 * a33 - a23 * a32;

		// Calculate the determinant
		return b00 * b11 - b01 * b10 + b02 * b09 + b03 * b08 - b04 * b07 + b05 * b06;
	}

	/**
	 * Multiplies two Mat4s
	 *
	 * @param {Mat4} out the receiving matrix
	 * @param {Mat4} a the first operand
	 * @param {Mat4} b the second operand
	 * @returns {Mat4} out
	 */
	public static Mat4 multiply(Mat4 out, Mat4 a, Mat4 b) {
		float a00 = a.m[0], a01 = a.m[1], a02 = a.m[2], a03 = a.m[3];
		float a10 = a.m[4], a11 = a.m[5], a12 = a.m[6], a13 = a.m[7];
		float a20 = a.m[8], a21 = a.m[9], a22 = a.m[10], a23 = a.m[11];
		float a30 = a.m[12], a31 = a.m[13], a32 = a.m[14], a33 = a.m[15];

		// Cache only the current line of the second matrix
		float b0  = b.m[0], b1 = b.m[1], b2 = b.m[2], b3 = b.m[3];
		out.m[0] = b0*a00 + b1*a10 + b2*a20 + b3*a30;
		out.m[1] = b0*a01 + b1*a11 + b2*a21 + b3*a31;
		out.m[2] = b0*a02 + b1*a12 + b2*a22 + b3*a32;
		out.m[3] = b0*a03 + b1*a13 + b2*a23 + b3*a33;

		b0 = b.m[4]; b1 = b.m[5]; b2 = b.m[6]; b3 = b.m[7];
		out.m[4] = b0*a00 + b1*a10 + b2*a20 + b3*a30;
		out.m[5] = b0*a01 + b1*a11 + b2*a21 + b3*a31;
		out.m[6] = b0*a02 + b1*a12 + b2*a22 + b3*a32;
		out.m[7] = b0*a03 + b1*a13 + b2*a23 + b3*a33;

		b0 = b.m[8]; b1 = b.m[9]; b2 = b.m[10]; b3 = b.m[11];
		out.m[8] = b0*a00 + b1*a10 + b2*a20 + b3*a30;
		out.m[9] = b0*a01 + b1*a11 + b2*a21 + b3*a31;
		out.m[10] = b0*a02 + b1*a12 + b2*a22 + b3*a32;
		out.m[11] = b0*a03 + b1*a13 + b2*a23 + b3*a33;

		b0 = b.m[12]; b1 = b.m[13]; b2 = b.m[14]; b3 = b.m[15];
		out.m[12] = b0*a00 + b1*a10 + b2*a20 + b3*a30;
		out.m[13] = b0*a01 + b1*a11 + b2*a21 + b3*a31;
		out.m[14] = b0*a02 + b1*a12 + b2*a22 + b3*a32;
		out.m[15] = b0*a03 + b1*a13 + b2*a23 + b3*a33;
		return out;
	}

	/**
	 * Translate a Mat4 by the given vector
	 *
	 * @param {Mat4} out the matrix to translate
	 * @param {float} x to translate by
	 * @param {float} y to translate by
	 * @param {float} z to translate by
	 * @returns {Mat4} out
	 */
	public static Mat4 translate(Mat4 out, float x, float y, float z) {
		out.m[12] = out.m[0] * x + out.m[4] * y + out.m[8] * z + out.m[12];
		out.m[13] = out.m[1] * x + out.m[5] * y + out.m[9] * z + out.m[13];
		out.m[14] = out.m[2] * x + out.m[6] * y + out.m[10] * z + out.m[14];
		out.m[15] = out.m[3] * x + out.m[7] * y + out.m[11] * z + out.m[15];
		return out;
	}

	/**
	 * Translate a Mat4 by the given vector
	 *
	 * @param {Mat4} out the matrix to translate
	 * @param {Vec3} the vector v to translate by
	 * @returns {Mat4} out
	 */
	public static Mat4 translate(Mat4 out, Vec3 v) {
		return Mat4.translate(out, v.x, v.y, v.z);
	}

	/**
	 * Scales the Mat4 by the dimensions in the given vec3 not using vectorization
	 *
	 * @param {Mat4} out the receiving matrix
	 * @param {Mat4} a the matrix to scale
	 * @param {float} x to scale the matrix by
	 * @param {float} y to scale the matrix by
	 * @param {float} z to scale the matrix by
	 * @returns {Mat4} out
	 **/
	public static Mat4 scale(Mat4 out, float x, float y, float z) {
		out.m[0] *= x;
		out.m[1] *= x;
		out.m[2] *= x;
		out.m[3] *= x;
		out.m[4] *= y;
		out.m[5] *= y;
		out.m[6] *= y;
		out.m[7] *= y;
		out.m[8] *= z;
		out.m[9] *= z;
		out.m[10] *= z;
		out.m[11] *= z;
		return out;
	}

	/**
	 * Scales the Mat4 by the dimensions in the given vec3 not using vectorization
	 *
	 * @param {Mat4} out the receiving matrix
	 * @param {Mat4} a the matrix to scale
	 * @param {Vec3} v the Vec3 to scale the matrix by
	 * @returns {Mat4} out
	 **/
	public static Mat4 scale(Mat4 out, Vec3 v) {
		return Mat4.scale(out, v.x, v.y, v.z);
	}

	/**
	 * Rotates a Mat4 by the given angle around the given axis
	 *
	 * @param {Mat4} out the matrix to rotate
	 * @param {float} rad the angle to rotate the matrix by
	 * @param {Vec3} axis the axis to rotate around
	 * @returns {Mat4} out
	 */
	public static Mat4 rotate(Mat4 out, float rad, Vec3 axis) {
		float x = axis.x, y = axis.y, z = axis.z;
		float len = (float) StrictMath.sqrt(x * x + y * y + z * z);
		float s, c, t;
		float a00, a01, a02, a03;
		float a10, a11, a12, a13;
		float a20, a21, a22, a23;
		float b00, b01, b02;
		float b10, b11, b12;
		float b20, b21, b22;

		if (Math.abs(len) < GLMatrix.EPSILON) { return null; }

		len = 1 / len;
		x *= len;
		y *= len;
		z *= len;

		s = (float) Math.sin(rad);
		c = (float) Math.cos(rad);
		t = 1 - c;

		a00 = out.m[0]; a01 = out.m[1]; a02 = out.m[2]; a03 = out.m[3];
		a10 = out.m[4]; a11 = out.m[5]; a12 = out.m[6]; a13 = out.m[7];
		a20 = out.m[8]; a21 = out.m[9]; a22 = out.m[10]; a23 = out.m[11];

		// Construct the elements of the rotation matrix
		b00 = x * x * t + c; b01 = y * x * t + z * s; b02 = z * x * t - y * s;
		b10 = x * y * t - z * s; b11 = y * y * t + c; b12 = z * y * t + x * s;
		b20 = x * z * t + y * s; b21 = y * z * t - x * s; b22 = z * z * t + c;

		// Perform rotation-specific matrix multiplication
		out.m[0] = a00 * b00 + a10 * b01 + a20 * b02;
		out.m[1] = a01 * b00 + a11 * b01 + a21 * b02;
		out.m[2] = a02 * b00 + a12 * b01 + a22 * b02;
		out.m[3] = a03 * b00 + a13 * b01 + a23 * b02;
		out.m[4] = a00 * b10 + a10 * b11 + a20 * b12;
		out.m[5] = a01 * b10 + a11 * b11 + a21 * b12;
		out.m[6] = a02 * b10 + a12 * b11 + a22 * b12;
		out.m[7] = a03 * b10 + a13 * b11 + a23 * b12;
		out.m[8] = a00 * b20 + a10 * b21 + a20 * b22;
		out.m[9] = a01 * b20 + a11 * b21 + a21 * b22;
		out.m[10] = a02 * b20 + a12 * b21 + a22 * b22;
		out.m[11] = a03 * b20 + a13 * b21 + a23 * b22;

		return out;
	}

	/**
	 * Rotates a matrix by the given angle around the X axis
	 *
	 * @param {Mat4} out the matrix to rotate
	 * @param {float} rad the angle to rotate the matrix by
	 * @returns {Mat4} out
	 */
	public static Mat4 rotateX(Mat4 out, float rad) {
		float s = (float) Math.sin(rad);
		float c = (float) Math.cos(rad);
		float a10 = out.m[4];
		float a11 = out.m[5];
		float a12 = out.m[6];
		float a13 = out.m[7];
		float a20 = out.m[8];
		float a21 = out.m[9];
		float a22 = out.m[10];
		float a23 = out.m[11];

		// Perform axis-specific matrix multiplication
		out.m[4] = a10 * c + a20 * s;
		out.m[5] = a11 * c + a21 * s;
		out.m[6] = a12 * c + a22 * s;
		out.m[7] = a13 * c + a23 * s;
		out.m[8] = a20 * c - a10 * s;
		out.m[9] = a21 * c - a11 * s;
		out.m[10] = a22 * c - a12 * s;
		out.m[11] = a23 * c - a13 * s;

		return out;
	}

	/**
	 * Rotates a matrix by the given angle around the Y axis
	 *
	 * @param {Mat4} out the matrix to rotate
	 * @param {float} rad the angle to rotate the matrix by
	 * @returns {Mat4} out
	 */
	public static Mat4 rotateY(Mat4 out, float rad) {
		float s = (float) Math.sin(rad);
		float c = (float) Math.cos(rad);
		float a00 = out.m[0];
		float a01 = out.m[1];
		float a02 = out.m[2];
		float a03 = out.m[3];
		float a20 = out.m[8];
		float a21 = out.m[9];
		float a22 = out.m[10];
		float a23 = out.m[11];

		// Perform axis-specific matrix multiplication
		out.m[0] = a00 * c - a20 * s;
		out.m[1] = a01 * c - a21 * s;
		out.m[2] = a02 * c - a22 * s;
		out.m[3] = a03 * c - a23 * s;
		out.m[8] = a00 * s + a20 * c;
		out.m[9] = a01 * s + a21 * c;
		out.m[10] = a02 * s + a22 * c;
		out.m[11] = a03 * s + a23 * c;

		return out;
	}

	/**
	 * Rotates a matrix by the given angle around the Z axis
	 *
	 * @param {Mat4} out the matrix to rotate
	 * @param {float} rad the angle to rotate the matrix by
	 * @returns {Mat4} out
	 */
	public static Mat4 rotateZ(Mat4 out, float rad) {
		float s = (float) Math.sin(rad);
		float c = (float) Math.cos(rad);
		float a00 = out.m[0];
		float a01 = out.m[1];
		float a02 = out.m[2];
		float a03 = out.m[3];
		float a10 = out.m[4];
		float a11 = out.m[5];
		float a12 = out.m[6];
		float a13 = out.m[7];

		// Perform axis-specific matrix multiplication
		out.m[0] = a00 * c + a10 * s;
		out.m[1] = a01 * c + a11 * s;
		out.m[2] = a02 * c + a12 * s;
		out.m[3] = a03 * c + a13 * s;
		out.m[4] = a10 * c - a00 * s;
		out.m[5] = a11 * c - a01 * s;
		out.m[6] = a12 * c - a02 * s;
		out.m[7] = a13 * c - a03 * s;

		return out;
	}

	/**
	 * Returns the translation vector component of a transformation
	 *  matrix. 
	 * @param  {Vec3} out Vector to receive translation component
	 * @param  {Mat4} mat Matrix to be decomposed (input)
	 * @return {Vec3} out
	 */
	public static Vec3 getTranslation(Vec3 out, Mat4 mat) {
		out.x = mat.m[12];
		out.y = mat.m[13];
		out.z = mat.m[14];

		return out;
	}

	/**
	 * Returns the scaling factor component of a transformation
	 *  matrix.
	 * @param  {Vec3} out Vector to receive scaling factor component
	 * @param  {Mat4} mat Matrix to be decomposed (input)
	 * @return {Vec3} out
	 */
	public static Vec3 getScaling(Vec3 out, Mat4 mat) {
		float m11 = mat.m[0];
		float m12 = mat.m[1];
		float m13 = mat.m[2];
		float m21 = mat.m[4];
		float m22 = mat.m[5];
		float m23 = mat.m[6];
		float m31 = mat.m[8];
		float m32 = mat.m[9];
		float m33 = mat.m[10];

		out.x = (float) StrictMath.sqrt(m11 * m11 + m12 * m12 + m13 * m13);
		out.y = (float) StrictMath.sqrt(m21 * m21 + m22 * m22 + m23 * m23);
		out.z = (float) StrictMath.sqrt(m31 * m31 + m32 * m32 + m33 * m33);

		return out;
	}

	/**
	 * Returns a quaternion representing the rotational component
	 *  of a transformation matrix.
	 * @param {Quat} out Quaternion to receive the rotation component
	 * @param {Mat4} mat Matrix to be decomposed (input)
	 * @return {Quat} out
	 */
	public static Quat getRotation(Quat out, Mat4 mat) {
		// Algorithm taken from http://www.euclideanspace.com/maths/geometry/rotations/conversions/matrixToQuaternion/index.htm
		float trace = mat.m[0] + mat.m[5] + mat.m[10];
		float S = 0;

		if (trace > 0) {
			S = (float) (StrictMath.sqrt(trace + 1.0) * 2);
			out.w = 0.25f * S;
			out.x = (mat.m[6] - mat.m[9]) / S;
			out.y = (mat.m[8] - mat.m[2]) / S;
			out.z = (mat.m[1] - mat.m[4]) / S;
		} else if ((mat.m[0] > mat.m[5])&&(mat.m[0] > mat.m[10])) {
			S = (float) StrictMath.sqrt(1.0 + mat.m[0] - mat.m[5] - mat.m[10]) * 2f;
			out.w = (mat.m[6] - mat.m[9]) / S;
			out.x = 0.25f * S;
			out.y = (mat.m[1] + mat.m[4]) / S;
			out.z = (mat.m[8] + mat.m[2]) / S;
		} else if (mat.m[5] > mat.m[10]) {
			S = (float) StrictMath.sqrt(1.0 + mat.m[5] - mat.m[0] - mat.m[10]) * 2f;
			out.w = (mat.m[8] - mat.m[2]) / S;
			out.x = (mat.m[1] + mat.m[4]) / S;
			out.y = 0.25f * S;
			out.z = (mat.m[6] + mat.m[9]) / S;
		} else {
			S = (float) StrictMath.sqrt(1.0 + mat.m[10] - mat.m[0] - mat.m[5]) * 2f;
			out.w = (mat.m[1] - mat.m[4]) / S;
			out.x = (mat.m[8] + mat.m[2]) / S;
			out.y = (mat.m[6] + mat.m[9]) / S;
			out.z = 0.25f * S;
		}

		return out;
	}

	/**
	 * Generates a frustum matrix with the given bounds
	 *
	 * @param {Mat4} out Mat4 frustum matrix will be written into
	 * @param {float} left Left bound of the frustum
	 * @param {float} right Right bound of the frustum
	 * @param {float} bottom Bottom bound of the frustum
	 * @param {float} top Top bound of the frustum
	 * @param {float} near Near bound of the frustum
	 * @param {float} far Far bound of the frustum
	 * @returns {Mat4} out
	 */
	public static Mat4 frustum(Mat4 out, float left, float right, float bottom, float top, float near, float far) {
		float rl = 1.f / (right - left);
		float tb = 1.f / (top - bottom);
		float nf = 1.f / (near - far);
		out.m[0] = (near * 2f) * rl;
		out.m[1] = 0;
		out.m[2] = 0;
		out.m[3] = 0;
		out.m[4] = 0;
		out.m[5] = (near * 2f) * tb;
		out.m[6] = 0;
		out.m[7] = 0;
		out.m[8] = (right + left) * rl;
		out.m[9] = (top + bottom) * tb;
		out.m[10] = (far + near) * nf;
		out.m[11] = -1f;
		out.m[12] = 0;
		out.m[13] = 0;
		out.m[14] = (far * near * 2f) * nf;
		out.m[15] = 0;
		return out;
	}

	/**
	 * Generates a perspective projection matrix with the given bounds
	 *
	 * @param {Mat4} out Mat4 frustum matrix will be written into
	 * @param {float} fovy Vertical field of view in radians
	 * @param {float} aspect Aspect ratio. typically viewport width/height
	 * @param {float} near Near bound of the frustum
	 * @param {float} far Far bound of the frustum
	 * @returns {Mat4} out
	 */
	public static void perspective(Mat4 out, float fovy, float aspect, float near, float far) {
		float f  = (float) (1.f / Math.tan(fovy / 2.f));
		float nf = 1.f / (near - far);
		out.m[0] = f / aspect;
		out.m[1] = 0;
		out.m[2] = 0;
		out.m[3] = 0;
		out.m[4] = 0;
		out.m[5] = f;
		out.m[6] = 0;
		out.m[7] = 0;
		out.m[8] = 0;
		out.m[9] = 0;
		out.m[10] = (far + near) * nf;
		out.m[11] = -1;
		out.m[12] = 0;
		out.m[13] = 0;
		out.m[14] = (2 * far * near) * nf;
		out.m[15] = 0;
	}

	public static Mat4 perspective(float fovy, float aspect, float near, float far) {
		Mat4 out = new Mat4();
		Mat4.perspective(out, fovy, aspect, near, far);
		return out;
	}

	/**
	 * Generates a orthogonal projection matrix with the given bounds
	 *
	 * @param {Mat4} out Mat4 frustum matrix will be written into
	 * @param {float} left Left bound of the frustum
	 * @param {float} right Right bound of the frustum
	 * @param {float} bottom Bottom bound of the frustum
	 * @param {float} top Top bound of the frustum
	 * @param {float} near Near bound of the frustum
	 * @param {float} far Far bound of the frustum
	 * @returns {Mat4} out
	 */
	public static Mat4 ortho(Mat4 out, float left, float right, float bottom, float top, float near, float far) {
		float lr = 1.f / (left - right);
		float bt = 1.f / (bottom - top);
		float nf = 1.f / (near - far);
		out.m[0] = -2.f * lr;
		out.m[1] = 0;
		out.m[2] = 0;
		out.m[3] = 0;
		out.m[4] = 0;
		out.m[5] = -2.f * bt;
		out.m[6] = 0;
		out.m[7] = 0;
		out.m[8] = 0;
		out.m[9] = 0;
		out.m[10] = 2.f * nf;
		out.m[11] = 0;
		out.m[12] = (left + right) * lr;
		out.m[13] = (top + bottom) * bt;
		out.m[14] = (far + near) * nf;
		out.m[15] = 1.f;
		return out;
	}

	/**
	 * Generates a look-at matrix with the given eye position, focal point, and up axis
	 *
	 * @param {Mat4} out mat4 frustum matrix will be written into
	 * @param {Vec3} eye Position of the viewer
	 * @param {Vec3} center Point the viewer is looking at
	 * @param {Vec3} up Vec3 pointing up
	 * @returns {Mat4} out
	 */
	public static Mat4 lookAt(Mat4 out, Vec3 eye, Vec3 center, Vec3 up) {
		float x0, x1, x2, y0, y1, y2, z0, z1, z2, len;
		float eyex = eye.x;
		float eyey = eye.y;
		float eyez = eye.z;
		float upx = up.x;
		float upy = up.y;
		float upz = up.z;
		float centerx = center.x;
		float centery = center.y;
		float centerz = center.z;

		if (Math.abs(eyex - centerx) < GLMatrix.EPSILON &&
				Math.abs(eyey - centery) < GLMatrix.EPSILON &&
				Math.abs(eyez - centerz) < GLMatrix.EPSILON) {
			return identity(out);
		}

		z0 = eyex - centerx;
		z1 = eyey - centery;
		z2 = eyez - centerz;

		len = (float) (1.f / StrictMath.sqrt(z0 * z0 + z1 * z1 + z2 * z2));
		z0 *= len;
		z1 *= len;
		z2 *= len;

		x0 = upy * z2 - upz * z1;
		x1 = upz * z0 - upx * z2;
		x2 = upx * z1 - upy * z0;
		len = (float) StrictMath.sqrt(x0 * x0 + x1 * x1 + x2 * x2);
		if (len == 0.f) {
			x0 = 0.f;
			x1 = 0.f;
			x2 = 0.f;
		} else {
			len = 1.f / len;
			x0 *= len;
			x1 *= len;
			x2 *= len;
		}

		y0 = z1 * x2 - z2 * x1;
		y1 = z2 * x0 - z0 * x2;
		y2 = z0 * x1 - z1 * x0;

		len = (float) StrictMath.sqrt(y0 * y0 + y1 * y1 + y2 * y2);
		if (len == 0.f) {
			y0 = 0.f;
			y1 = 0.f;
			y2 = 0.f;
		} else {
			len = 1.f / len;
			y0 *= len;
			y1 *= len;
			y2 *= len;
		}

		out.m[0] = x0;
		out.m[1] = y0;
		out.m[2] = z0;
		out.m[3] = 0.f;
		out.m[4] = x1;
		out.m[5] = y1;
		out.m[6] = z1;
		out.m[7] = 0.f;
		out.m[8] = x2;
		out.m[9] = y2;
		out.m[10] = z2;
		out.m[11] = 0.f;
		out.m[12] = -(x0 * eyex + x1 * eyey + x2 * eyez);
		out.m[13] = -(y0 * eyex + y1 * eyey + y2 * eyez);
		out.m[14] = -(z0 * eyex + z1 * eyey + z2 * eyez);
		out.m[15] = 1.f;

		return out;
	}

	/**
	 * Generates a matrix that makes something look at something else.
	 *
	 * @param {Mat4} out mat4 frustum matrix will be written into
	 * @param {Vec3} eye Position of the viewer
	 * @param {Vec3} center Point the viewer is looking at
	 * @param {Vec3} up vec3 pointing up
	 * @returns {Mat4} out
	 */
	public static Mat4 targetTo(Mat4 out, Vec3 eye, Vec3 target, Vec3 up) {
		float eyex = eye.x,
				eyey = eye.y,
				eyez = eye.z,
				upx = up.x,
				upy = up.y,
				upz = up.z;

		float z0 = eyex - target.x,
				z1 = eyey - target.y,
				z2 = eyez - target.z;

		float len = z0*z0 + z1*z1 + z2*z2;
		if (len > 0) {
			len = (float) (1.f / StrictMath.sqrt(len));
			z0 *= len;
			z1 *= len;
			z2 *= len;
		}

		float x0 = upy * z2 - upz * z1,
				x1 = upz * z0 - upx * z2,
				x2 = upx * z1 - upy * z0;

		out.m[0] = x0;
		out.m[1] = x1;
		out.m[2] = x2;
		out.m[3] = 0.f;
		out.m[4] = z1 * x2 - z2 * x1;
		out.m[5] = z2 * x0 - z0 * x2;
		out.m[6] = z0 * x1 - z1 * x0;
		out.m[7] = 0.f;
		out.m[8] = z0;
		out.m[9] = z1;
		out.m[10] = z2;
		out.m[11] = 0.f;
		out.m[12] = eyex;
		out.m[13] = eyey;
		out.m[14] = eyez;
		out.m[15] = 1.f;
		return out;
	};

}
