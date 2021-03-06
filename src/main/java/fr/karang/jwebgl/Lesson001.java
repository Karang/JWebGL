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
package fr.karang.jwebgl;

import fr.karang.jwebgl.webgl.WebGLBuffer;
import fr.karang.jwebgl.webgl.WebGLRenderingContext;

import static fr.karang.jwebgl.webgl.WebGLRenderingContext.*;

import fr.karang.jwebgl.glmatrix.Mat4;
import fr.karang.jwebgl.util.Shader;

/**
 * WebGL Lesson 1 – A triangle and a square
 * From : http://learningwebgl.com/blog/?p=28
 */
public class Lesson001 {

	public static String fragShader =
			"precision mediump float;\r\n" + 
			"\r\n" + 
			"void main(void) {\r\n" + 
			"    gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);\r\n" + 
			"}";

	public static String vertShader =
			"attribute vec3 aVertexPosition;\r\n" + 
			"\r\n" + 
			"uniform mat4 uMVMatrix;\r\n" + 
			"uniform mat4 uPMatrix;\r\n" + 
			"\r\n" + 
			"void main(void) {\r\n" + 
			"    gl_Position = uPMatrix * uMVMatrix * vec4(aVertexPosition, 1.0);\r\n" + 
			"}";
	
	public static Shader shader;
	
	public static WebGLBuffer triangleVertexPositionBuffer;
	public static WebGLBuffer squareVertexPositionBuffer;
	
	public static Mat4 pMatrix = new Mat4();
	public static Mat4 mvMatrix = new Mat4();

	public static void initShaders() {
		shader = new Shader(vertShader, fragShader);
	}

	public static void initBuffers() {
		triangleVertexPositionBuffer = gl.createBuffer();
		gl.bindBuffer(ARRAY_BUFFER, triangleVertexPositionBuffer);

		float[] vertices = new float[] {
			0.f,  1.f,  0.f,
			-1.f, -1.f,  0.f,
			1.f, -1.f,  0.f
		};

		gl.bufferData(ARRAY_BUFFER, vertices, STATIC_DRAW);

		squareVertexPositionBuffer = gl.createBuffer();
		gl.bindBuffer(ARRAY_BUFFER, squareVertexPositionBuffer);
		vertices = new float[] {
			1.f,  1.f,  0.f,
			-1.f,  1.f,  0.f,
			1.f, -1.f,  0.f,
			-1.f, -1.f,  0.f
		};
		gl.bufferData(ARRAY_BUFFER, vertices, STATIC_DRAW);
	}

	public static void setMatrixUniforms() {
		shader.uniformMatrix4fv("uMVMatrix", false, mvMatrix);
		shader.uniformMatrix4fv("uPMatrix", false, pMatrix);
	}

	public static void drawScene() {
		gl.viewport(0, 0, gl.getWidth(), gl.getHeight());
		gl.clear(COLOR_BUFFER_BIT | DEPTH_BUFFER_BIT);

		Mat4.perspective(pMatrix, 45f, gl.getWidth() / gl.getHeight(), 0.1f, 100.0f);
		
		Mat4.identity(mvMatrix);
		Mat4.translate(mvMatrix, -1.5f, 0.f, -7.f);

		gl.bindBuffer(ARRAY_BUFFER, triangleVertexPositionBuffer);
		gl.vertexAttribPointer(shader.getAttribLocation("aVertexPosition"), 3, FLOAT, false, 0, 0);
		
		setMatrixUniforms();

		gl.drawArrays(TRIANGLES, 0, 3);

		Mat4.translate(mvMatrix, 3.0f, 0.0f, 0.0f);
		
		gl.bindBuffer(ARRAY_BUFFER, squareVertexPositionBuffer);
		gl.vertexAttribPointer(shader.getAttribLocation("aVertexPosition"), 3, FLOAT, false, 0, 0);

		setMatrixUniforms();

		gl.drawArrays(TRIANGLE_STRIP, 0, 4);
	}
	
	public static void main(String[] args) {
		setContext(WebGLRenderingContext.getWebGLCtxById("canvas"));
		initShaders();
		initBuffers();

		gl.clearColor(0.0f, 0.0f, 0.0f, 1.0f);
		gl.enable(DEPTH_TEST);

		drawScene();
	}
}
