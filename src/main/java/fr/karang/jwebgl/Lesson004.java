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

/**
 * WebGL Lesson 4 – some real 3D objects
 * From : http://learningwebgl.com/blog/?p=370
 */
public class Lesson004 {

	public static String fragShader =
			"precision mediump float;\r\n" + 
			"\r\n" + 
			"varying vec4 vColor;\r\n" + 
			"\r\n" + 
			"void main(void) {\r\n" + 
			"	gl_FragColor = vColor;\r\n" + 
			"}";
	
	public static String vertShader =
			"attribute vec3 aVertexPosition;\r\n" + 
			"attribute vec4 aVertexColor;\r\n" + 
			"\r\n" + 
			"uniform mat4 uMVMatrix;\r\n" + 
			"uniform mat4 uPMatrix;\r\n" + 
			"\r\n" + 
			"varying vec4 vColor;\r\n" + 
			"\r\n" + 
			"void main(void) {\r\n" + 
			"	gl_Position = uPMatrix * uMVMatrix * vec4(aVertexPosition, 1.0);\r\n" + 
			"	vColor = aVertexColor;\r\n" + 
			"}";
	
	public static void main(String[] args) {
		
	}
}
