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

import static fr.karang.jwebgl.webgl.WebGLRenderingContext.*;

import java.util.ArrayList;
import java.util.List;

import de.mirkosertic.bytecoder.annotations.Export;
import fr.karang.jwebgl.glmatrix.Mat4;
import fr.karang.jwebgl.glmatrix.Vec3;
import fr.karang.jwebgl.util.Shader;
import fr.karang.jwebgl.webgl.WebGLBuffer;
import fr.karang.jwebgl.webgl.WebGLRenderingContext;

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

    public static Shader shader;

    public static WebGLBuffer pyramidVertexPositionBuffer;
    public static WebGLBuffer pyramidVertexColorBuffer;
    public static WebGLBuffer cubeVertexPositionBuffer;
    public static WebGLBuffer cubeVertexColorBuffer;
    public static WebGLBuffer cubeVertexIndexBuffer;

    public static List<Mat4> mvMatrixStack = new ArrayList<Mat4>();
    public static Mat4 pMatrix = new Mat4();
    public static Mat4 mvMatrix = new Mat4();

    public static long lastTime = 0;
    public static float rPyramid = 0;
    public static float rCube = 0;

    public static void initShaders() {
        shader = new Shader(vertShader, fragShader);
    }

    public static void mvPushMatrix() {
        mvMatrixStack.add(Mat4.clone(mvMatrix));
    }

    public static void mvPopMatrix() {
        if (mvMatrixStack.size() == 0) {
            return;
        }
        mvMatrix = mvMatrixStack.get(mvMatrixStack.size()-1);
        mvMatrixStack.remove(mvMatrix);
    }

    public static void setMatrixUniforms() {
        shader.uniformMatrix4fv("uMVMatrix", false, mvMatrix);
        shader.uniformMatrix4fv("uPMatrix", false, pMatrix);
    }

    public static void initBuffers() {
        pyramidVertexPositionBuffer = gl.createBuffer();
        gl.bindBuffer(ARRAY_BUFFER, pyramidVertexPositionBuffer);
        float[] vertices = new float[] {
                // Front face
                0.0f,   1.0f,  0.0f,
                -1.0f, -1.0f,  1.0f,
                1.0f,  -1.0f,  1.0f,
                // Right face
                0.0f,  1.0f,  0.0f,
                1.0f, -1.0f,  1.0f,
                1.0f, -1.0f, -1.0f,
                // Back face
                0.0f,   1.0f,  0.0f,
                1.0f,  -1.0f, -1.0f,
                -1.0f, -1.0f, -1.0f,
                // Left face
                0.0f,   1.0f,  0.0f,
                -1.0f, -1.0f, -1.0f,
                -1.0f, -1.0f,  1.0f
        };
        gl.bufferData(ARRAY_BUFFER, vertices, STATIC_DRAW);

        pyramidVertexColorBuffer = gl.createBuffer();
        gl.bindBuffer(ARRAY_BUFFER, pyramidVertexColorBuffer);
        float[] colors = new float[] {
                // Front face
                1.0f, 0.0f, 0.0f, 1.0f,
                0.0f, 1.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                // Right face
                1.0f, 0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 1.0f, 0.0f, 1.0f,
                // Back face
                1.0f, 0.0f, 0.0f, 1.0f,
                0.0f, 1.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                // Left face
                1.0f, 0.0f, 0.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 1.0f, 0.0f, 1.0f
        };
        gl.bufferData(ARRAY_BUFFER, colors, STATIC_DRAW);

        cubeVertexPositionBuffer = gl.createBuffer();
        gl.bindBuffer(ARRAY_BUFFER, cubeVertexPositionBuffer);
        vertices = new float[] {
                // Front face
                -1.0f, -1.0f,  1.0f,
                1.0f,  -1.0f,  1.0f,
                1.0f,   1.0f,  1.0f,
                -1.0f,  1.0f,  1.0f,
                // Back face
                -1.0f, -1.0f, -1.0f,
                -1.0f,  1.0f, -1.0f,
                1.0f,  1.0f, -1.0f,
                1.0f, -1.0f, -1.0f,
                // Top face
                -1.0f,  1.0f, -1.0f,
                -1.0f,  1.0f,  1.0f,
                1.0f,  1.0f,  1.0f,
                1.0f,  1.0f, -1.0f,
                // Bottom face
                -1.0f, -1.0f, -1.0f,
                1.0f, -1.0f, -1.0f,
                1.0f, -1.0f,  1.0f,
                -1.0f, -1.0f,  1.0f,
                // Right face
                1.0f, -1.0f, -1.0f,
                1.0f,  1.0f, -1.0f,
                1.0f,  1.0f,  1.0f,
                1.0f, -1.0f,  1.0f,
                // Left face
                -1.0f, -1.0f, -1.0f,
                -1.0f, -1.0f,  1.0f,
                -1.0f,  1.0f,  1.0f,
                -1.0f,  1.0f, -1.0f
        };
        gl.bufferData(ARRAY_BUFFER, vertices, STATIC_DRAW);

        cubeVertexColorBuffer = gl.createBuffer();
        gl.bindBuffer(ARRAY_BUFFER, cubeVertexColorBuffer);
        float[][] packed_colors = new float[][] {
            {1.0f, 0.0f, 0.0f, 1.0f}, // Front face
            {1.0f, 1.0f, 0.0f, 1.0f}, // Back face
            {0.0f, 1.0f, 0.0f, 1.0f}, // Top face
            {1.0f, 0.5f, 0.5f, 1.0f}, // Bottom face
            {1.0f, 0.0f, 1.0f, 1.0f}, // Right face
            {0.0f, 0.0f, 1.0f, 1.0f}  // Left face
        };
        colors = new float[6*4*4];
        for (int i=0 ; i<6 ; i++) {
            float[] color = packed_colors[i];
            for (int j=0 ; j < 4; j++) {
                int k = (i*4+j)*4;
                colors[k] = color[0];
                colors[k+1] = color[1];
                colors[k+2] = color[2];
                colors[k+3] = color[3];
            }
        }
        gl.bufferData(ARRAY_BUFFER, colors, STATIC_DRAW);

        cubeVertexIndexBuffer = gl.createBuffer();
        gl.bindBuffer(ELEMENT_ARRAY_BUFFER, cubeVertexIndexBuffer);
        int[] cubeVertexIndices = new int[] {
                0, 1, 2,      0, 2, 3,    // Front face
                4, 5, 6,      4, 6, 7,    // Back face
                8, 9, 10,     8, 10, 11,  // Top face
                12, 13, 14,   12, 14, 15, // Bottom face
                16, 17, 18,   16, 18, 19, // Right face
                20, 21, 22,   20, 22, 23  // Left face
        };
        gl.bufferData(ELEMENT_ARRAY_BUFFER, cubeVertexIndices, STATIC_DRAW);
    }

    public static void drawScene() {
        gl.viewport(0, 0, gl.getWidth(), gl.getHeight());
        gl.clear(COLOR_BUFFER_BIT | DEPTH_BUFFER_BIT);

        Mat4.perspective(pMatrix, 45f, gl.getWidth() / gl.getHeight(), 0.1f, 100.0f);

        Mat4.identity(mvMatrix);
        Mat4.translate(mvMatrix, -1.5f, 0.f, -8.f);
        mvPushMatrix();

        Mat4.rotateY(mvMatrix, (float)Math.toRadians(rPyramid));

        gl.bindBuffer(ARRAY_BUFFER, pyramidVertexPositionBuffer);
        gl.vertexAttribPointer(shader.getAttribLocation("aVertexPosition"), 3, FLOAT, false, 0, 0);

        gl.bindBuffer(ARRAY_BUFFER, pyramidVertexColorBuffer);
        gl.vertexAttribPointer(shader.getAttribLocation("aVertexColor"), 4, FLOAT, false, 0, 0);

        setMatrixUniforms();

        gl.drawArrays(TRIANGLES, 0, 12);

        mvPopMatrix();
        Mat4.translate(mvMatrix, 3.0f, 0.0f, 0.0f);
        mvPushMatrix();

        Mat4.rotate(mvMatrix, (float)Math.toRadians(rCube), new Vec3(1, 1, 1));
        gl.bindBuffer(ARRAY_BUFFER, cubeVertexPositionBuffer);
        gl.vertexAttribPointer(shader.getAttribLocation("aVertexPosition"), 3, FLOAT, false, 0, 0);

        gl.bindBuffer(ARRAY_BUFFER, cubeVertexColorBuffer);
        gl.vertexAttribPointer(shader.getAttribLocation("aVertexColor"), 4, FLOAT, false, 0, 0);

        gl.bindBuffer(ELEMENT_ARRAY_BUFFER, cubeVertexIndexBuffer);

        setMatrixUniforms();

        gl.drawElements(TRIANGLES, 36, UNSIGNED_SHORT, 0);
        mvPopMatrix();
    }
    
    public static void animate() {
        long timeNow = System.currentTimeMillis();
        if (lastTime != 0) {
            long elapsed =  timeNow - lastTime;
            rPyramid += (90 * elapsed) / 1000.0;
            rCube -= (75 * elapsed) / 1000.0;
        }
        lastTime = timeNow;
    }
    
    @Export("tick")
    public static void tick() {
        animate();
        drawScene();
    }

    public static void main(String[] args) {
        setContext(WebGLRenderingContext.getWebGLCtxById("canvas"));
        initShaders();
        initBuffers();

        gl.clearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.enable(DEPTH_TEST);
    }
}
