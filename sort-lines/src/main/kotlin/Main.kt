import java.io.File
import java.io.FileInputStream
import java.io.FileWriter
import java.util.*

fun main(args: Array<String>) {
	for(file in File(".").listFiles()) {
		if(!file.name.endsWith(".txt"))
			continue
		val lines = mutableListOf<String>()
		Scanner(FileInputStream(file)).use {
			while(it.hasNextLine()) {
				lines.add(it.nextLine())
			}
		}
		lines.sort()
		FileWriter(file).use {
			for(line in lines) {
				it.write(line)
				it.write("\n")
			}
		}
	}
}