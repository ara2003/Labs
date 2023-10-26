package com.example.labs.giis_4

import com.example.labs.giis_4.assimp.AssimpMesh
import com.example.labs.giis_4.assimp.AssimpScene
import com.greentree.commons.data.resource.Resource
import org.lwjgl.assimp.Assimp
import org.lwjgl.system.MemoryUtil
import java.io.IOException
import java.nio.ByteBuffer

fun loadMesh(res: Resource): AssimpMesh {
	return loadScene(res).mMeshes(0)
}

fun loadScene(res: Resource): AssimpScene {
	var data: ByteBuffer
	try {
		res.open().use {
			var _data: ByteArray
			_data = it.readAllBytes()
			data = MemoryUtil.memCalloc(_data.size)
			data.put(_data)
			data.flip()
		}
	} catch(e: IOException) {
		throw IllegalArgumentException(e)
	}
	try {
		Assimp.aiImportFileFromMemory(
			data, Assimp.aiProcess_Triangulate
					or Assimp.aiProcess_ValidateDataStructure or Assimp.aiProcess_OptimizeMeshes, ""
		).use { scene ->
			if(scene == null) {
				val error = Assimp.aiGetErrorString()
				throw IllegalArgumentException(error)
			}
			return AssimpScene(scene)
		}
	} finally {
		MemoryUtil.memFree(data)
	}
}