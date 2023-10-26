package com.example.labs.giis_4.assimp;

import org.lwjgl.assimp.AIMesh;
import org.lwjgl.assimp.AIScene;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class AssimpScene implements Serializable {

    private static final long serialVersionUID = 1L;

    private final AssimpMesh[] mMeshes;

    public AssimpScene(AIScene scene) {
        final var mNumMeshes = scene.mNumMeshes();
        final var mMeshes = scene.mMeshes();
        this.mMeshes = new AssimpMesh[mNumMeshes];
        for (int i = 0; i < mNumMeshes; i++) {
            final var amesh = AIMesh.create(mMeshes.get());
            final var mesh = new AssimpMesh(amesh);
            this.mMeshes[i] = mesh;
        }
    }

    @Deprecated
    public AssimpMesh[] mMeshes() {
        return mMeshes.clone();
    }

    public AssimpMesh mMeshes(int index) {
        return mMeshes[index];
    }

    public int mNumMeshes() {
        return mMeshes.length;
    }

    private static final class BufferInputStream extends InputStream {

        private final Iterator<Byte> buffer;

        public BufferInputStream(ByteBuffer buffer) {
            final var buf = new ArrayList<Byte>();
            while (buffer.hasRemaining())
                buf.add(buffer.get());
            this.buffer = buf.iterator();
        }

        @Override
        public int read() throws IOException {
            if (buffer.hasNext()) {
                final var b = buffer.next();
                return Byte.toUnsignedInt(b);
            }
            return -1;
        }

    }

}
