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
package fr.karang.jwebgl.glmatrix;

public class Mat4 {

	public float[] m = new float[16];

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

	public static void identity(Mat4 out) {
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
	}

	public static void perspective(float fovy, float aspect, float near, float far, Mat4 out) {
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
		Mat4.perspective(fovy, aspect, near, far, out);
		return out;
	}

	public static void translate(Mat4 out, float x, float y, float z) {
		out.m[12] = out.m[0] * x + out.m[4] * y + out.m[8] * z + out.m[12];
		out.m[13] = out.m[1] * x + out.m[5] * y + out.m[9] * z + out.m[13];
		out.m[14] = out.m[2] * x + out.m[6] * y + out.m[10] * z + out.m[14];
		out.m[15] = out.m[3] * x + out.m[7] * y + out.m[11] * z + out.m[15];
	}

	public static Mat4 multiply(Mat4 a, Mat4 b) {
		Mat4 out = new Mat4();
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
}
