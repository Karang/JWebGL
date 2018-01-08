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

package fr.karang.jwebgl.util;

import static fr.karang.jwebgl.webgl.WebGLRenderingContext.*;

import fr.karang.jwebgl.glmatrix.Mat4;
import fr.karang.jwebgl.webgl.WebGLProgram;
import fr.karang.jwebgl.webgl.WebGLShader;
import fr.karang.jwebgl.webgl.WebGLUniformLocation;

public class Shader {

	public final WebGLProgram program;
	
	public Shader(String vert_src, String frag_src) {
		WebGLShader vert = getShader(vert_src, VERTEX_SHADER);
		WebGLShader frag = getShader(frag_src, FRAGMENT_SHADER);
		
		program = gl.createProgram();

		gl.attachShader(program, vert);
		gl.attachShader(program, frag);
		gl.linkProgram(program);

		gl.useProgram(program);
	}
	
	public int getAttribLocation(String name) {
	    int loc = gl.getAttribLocation(program, name);
	    gl.enableVertexAttribArray(loc);
		return loc;
	}
	
	public WebGLUniformLocation getUniformLocation(String name) {
		return gl.getUniformLocation(program, name);
	}
	
	public void uniformMatrix4fv(String name, boolean transpose, Mat4 mat) {
		gl.uniformMatrix4fv(getUniformLocation(name), transpose, mat.m);
	}
	
	private WebGLShader getShader(String source, int type) {
		WebGLShader shad = gl.createShader(type);
		gl.shaderSource(shad, source);
		gl.compileShader(shad);

		System.out.println(gl.getShaderInfoLog(shad));
		
		return shad;
	}
}
