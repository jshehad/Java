import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Test;

public class UnitTests4_sample {
	private static int passed = 0;

	@Test
	public void test0() {
		Entity.setEntity(10000);
		Entity entity = new Bacteria(Strength.HIGH);
		Entity neighbor = new Bacteria(Strength.HIGH);
		Entity.bloodstream[0] = entity;
		Entity.bloodstream[1] = neighbor;
		entity.touchNeighbor(neighbor);
		assertEquals("bacteria", Entity.bloodstream[2].getDNA());
		assertNotEquals(0, ++passed);
	}

	@Test
	public void test1() {
		Entity[] targets1 = { new Bacteria(Strength.DEAD) };
		Entity entity = new Lymphocyte("large", targets1);
		Entity neighbor = new Bacteria(Strength.HIGH);
		assertEquals("WBC\nkilled in lymphocyte\n", entity.touchNeighbor(neighbor));
		assertEquals(Strength.DEAD, neighbor.getStrength());
		assertNotEquals(0, ++passed);
	}

	@Test
	public void test2() {
		Entity[] targets2 = { new Virus(Strength.DEAD) };
		Entity entity = new Macrophage("medium", targets2);
		Entity neighbor = new Neutrophil("medium", targets2, true);
		neighbor.setStrength(Strength.LOW);
		assertEquals("macro\nWBC\nkilled neutro\n", entity.touchNeighbor(neighbor));
		assertEquals(Strength.DEAD, neighbor.getStrength());
		assertNotEquals(0, ++passed);
	}

	@Test
	public void test3() {
		Entity[] targets2 = { new Virus(Strength.DEAD) };
		Entity entity = new Macrophage("medium", targets2);
		Entity neighbor = new Neutrophil("medium", targets2, true);
		assertEquals("macro\nWBC\n", entity.touchNeighbor(neighbor));
		assertEquals(Strength.HIGH, neighbor.getStrength());
		assertNotEquals(0, ++passed);
	}

	@Test
	public void test4() {
		Entity[] targets2 = { new Virus(Strength.DEAD) };
		Entity entity = new Macrophage("medium", targets2);
		Entity neighbor = new Neutrophil("medium", targets2, true);
		assertEquals("macro\nWBC\n", entity.touchNeighbor(neighbor));
		assertEquals(Strength.HIGH, neighbor.getStrength());
		assertNotEquals(0, ++passed);
	}

	@Test
	public void test5() {
		Entity[] targets2 = { new Virus(Strength.DEAD) };
		Entity entity = new Neutrophil("medium", targets2, true);
		Entity neighbor = new Cytokine();
		assertEquals("neutro\nWBC\nsniffed\n", entity.touchNeighbor(neighbor));
		assertEquals(Strength.DEAD, neighbor.getStrength());
		assertNotEquals(0, ++passed);
	}

	@Test
	public void test6() {
		Entity entity = new Cytokine();
		Entity neighbor = new Virus(Strength.HIGH);
		assertEquals("cyto\n", entity.touchNeighbor(neighbor));
		assertEquals(Strength.HIGH, neighbor.getStrength());
		assertNotEquals(0, ++passed);
	}

	@Test
	public void test7() {
		Entity[] targets2 = { new Virus(Strength.DEAD) };
		Entity entity = new Neutrophil("medium", targets2, true);
		Entity neighbor = new Cytokine();
		assertEquals("neutro\nWBC\nsniffed\n", entity.touchNeighbor(neighbor));
		assertEquals(Strength.DEAD, neighbor.getStrength());
		assertNotEquals(0, ++passed);
	}

	@Test
	public void test8() {
		Entity[] targets2 = { new Virus(Strength.DEAD) };
		Entity entity = new Virus(Strength.HIGH);
		Entity neighbor = new Neutrophil("medium", targets2, true);
		assertEquals("virus\ninfected neutrophil\n", entity.touchNeighbor(neighbor));
		assertEquals("virus", neighbor.getDNA());
		assertNotEquals(0, ++passed);
	}

	@Test
	public void test9() {
		Entity[] targets2 = { new Virus(Strength.DEAD) };
		Entity entity = new Tester(targets2);
		Entity neighbor = new Neutrophil("medium", targets2, true);
		assertEquals("WBC\n", entity.touchNeighbor(neighbor));
		assertNotEquals(0, ++passed);
	}

	@Test
	public void test10() {
		Entity[] targets2 = { new Virus(Strength.DEAD) };
		Entity entity = new Tester(targets2);
		Entity neighbor = new Virus(Strength.HIGH);
		assertEquals("WBC\ntester", entity.touchNeighbor(neighbor));
		assertEquals(Strength.DEAD, neighbor.getStrength());
		assertNotEquals(0, ++passed);
	}

	public class Tester extends WhiteBloodCell {

		public Tester(Entity[] targets) {
			super("none", targets);
		}

		public String absorb(Entity in) {
			in.kill();
			return "tester";
		}

		public void release() {

		}

	}

	@Test
	public void testStyleAbstract() {

		assertEquals("passed", checkAbstractTouchNeighbor());
		// assertEquals("passed",checkTouchNeighborCallsAbsorb());
		assertEquals("passed", checkAbstract("absorb", "absorb should be abstract methods in WhiteBloodCell."));
		assertEquals("passed", checkAbstract("release", "release should be abstract methods in WhiteBloodCell."));
		assertNotEquals(0, ++passed);
	}

	/*
	 * Neutrophil should override the parent's touchNeighbor method. Macrophage
	 * should override the parent's touchNeighbor method.
	 */
	@Test
	public void testStyleOverride() {
		assertEquals("passed", checkOverride("Neutrophil.java", "touchNeighbor",
				"Neutrophil should override the parent's touchNeighbor method."));
		assertEquals("passed", checkOverride("Macrophage.java", "touchNeighbor",
				"Macrophage should override the parent's touchNeighbor method."));
		assertNotEquals(0, ++passed);
	}

	/*
	 * Neutrophil's touchNeighbor method should call the parent method. Macrophage's
	 * touchNeighbor method should call the parent method. Avoid attribute shadowing
	 * in any of the child classes.
	 */

	@Test
	public void testStyleInheritanceReuse() {
		assertEquals("passed", checkParentCall("Neutrophil.java", "touchNeighbor",
				"Neutrophil's touchNeighbor method should call the parent method."));
		assertEquals("passed", checkParentCall("Macrophage.java", "touchNeighbor",
				"Macrophage's touchNeighbor method should call the parent method."));
		assertEquals("passed", checkShadowing("WhiteBloodCell.java", "String", "dna",
				"WhiteBloodCell: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("WhiteBloodCell.java", "Strength", "strength",
				"WhiteBloodCell: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("WhiteBloodCell.java", "Entity[]", "bloodstream",
				"WhiteBloodCell: Avoid attribute shadowing in any of the child classes."));

		assertEquals("passed", checkShadowing("Neutrophil.java", "String", "dna",
				"Neutrophil: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Neutrophil.java", "Strength", "strength",
				"Neutrophil: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Neutrophil.java", "Entity[]", "bloodstream",
				"Neutrophil: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Neutrophil.java", "String", "nucleusType",
				"Neutrophil: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Neutrophil.java", "Entity[]", "targets",
				"Neutrophil: Avoid attribute shadowing in any of the child classes."));

		assertEquals("passed", checkShadowing("Lymphocyte.java", "String", "dna",
				"Lymphocyte: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Lymphocyte.java", "Strength", "strength",
				"Lymphocyte: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Lymphocyte.java", "Entity[]", "bloodstream",
				"Lymphocyte: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Lymphocyte.java", "String", "nucleusType",
				"Lymphocyte: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Lymphocyte.java", "Entity[]", "targets",
				"Lymphocyte: Avoid attribute shadowing in any of the child classes."));

		assertEquals("passed", checkShadowing("Macrophage.java", "String", "dna",
				"Macrophage: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Macrophage.java", "Strength", "strength",
				"Macrophage: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Macrophage.java", "Entity[]", "bloodstream",
				"Macrophage: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Macrophage.java", "String", "nucleusType",
				"Macrophage: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Macrophage.java", "Entity[]", "targets",
				"Macrophage: Avoid attribute shadowing in any of the child classes."));

		assertEquals("passed", checkShadowing("Virus.java", "String", "dna",
				"Virus: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Virus.java", "Strength", "strength",
				"Virus: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Virus.java", "Entity[]", "bloodstream",
				"Virus: Avoid attribute shadowing in any of the child classes."));

		assertEquals("passed", checkShadowing("Cytokine.java", "String", "dna",
				"Cytokine: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Cytokine.java", "Strength", "strength",
				"Cytokine: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Cytokine.java", "Entity[]", "bloodstream",
				"Cytokine: Avoid attribute shadowing in any of the child classes."));

		assertEquals("passed", checkShadowing("Bacteria.java", "String", "dna",
				"Bacteria: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Bacteria.java", "Strength", "strength",
				"Bacteria: Avoid attribute shadowing in any of the child classes."));
		assertEquals("passed", checkShadowing("Bacteria.java", "Entity[]", "bloodstream",
				"Bacteria: Avoid attribute shadowing in any of the child classes."));
		assertNotEquals(0, ++passed);
	}

	/*
	 * All child classes appropriately use the parent class' constructors.
	 * The @Override tag is used in all the appropriate places. All appropriate
	 * attributes are private.
	 */

	@Test
	public void testStyleInheritanceCorrectness() {
		assertEquals("passed", checkSuperCtor("WhiteBloodCell",
				"WhiteBloodCell: All child classes appropriately use the parent class' constructors."));
		assertEquals("passed", checkSuperCtor("Neutrophil",
				"Neutrophil: All child classes appropriately use the parent class' constructors."));
		assertEquals("passed", checkSuperCtor("Lymphocyte",
				"Lymphocyte: All child classes appropriately use the parent class' constructors."));
		assertEquals("passed", checkSuperCtor("Macrophage",
				"Macrophage: All child classes appropriately use the parent class' constructors."));
		assertEquals("passed",
				checkSuperCtor("Virus", "Virus: All child classes appropriately use the parent class' constructors."));
		assertEquals("passed", checkSuperCtor("Cytokine",
				"Cytokine: All child classes appropriately use the parent class' constructors."));
		assertEquals("passed", checkSuperCtor("Bacteria",
				"Bacteria: All child classes appropriately use the parent class' constructors."));

		assertEquals("passed", checkOverride("WhiteBloodCell.java", "touchNeighbor",
				"WhiteBloodCell: The @Override tag is used in all the appropriate places."));

		assertEquals("passed", checkOverride("Neutrophil.java", "absorb",
				"Neutrophil: The @Override tag is used in all the appropriate places."));
		assertEquals("passed", checkOverride("Neutrophil.java", "release",
				"Neutrophil: The @Override tag is used in all the appropriate places."));
		assertEquals("passed", checkOverride("Neutrophil.java", "touchNeighbor",
				"Neutrophil: The @Override tag is used in all the appropriate places."));

		assertEquals("passed", checkOverride("Lymphocyte.java", "absorb",
				"Lymphocyte: The @Override tag is used in all the appropriate places."));
		assertEquals("passed", checkOverride("Lymphocyte.java", "release",
				"Lymphocyte: The @Override tag is used in all the appropriate places."));

		assertEquals("passed", checkOverride("Macrophage.java", "absorb",
				"Macrophage: The @Override tag is used in all the appropriate places."));
		assertEquals("passed", checkOverride("Macrophage.java", "release",
				"Macrophage: The @Override tag is used in all the appropriate places."));
		assertEquals("passed", checkOverride("Macrophage.java", "touchNeighbor",
				"Macrophage: The @Override tag is used in all the appropriate places."));

		assertEquals("passed", checkOverride("Cytokine.java", "touchNeighbor",
				"Cytokine: The @Override tag is used in all the appropriate places."));

		assertEquals("passed", checkOverride("Bacteria.java", "touchNeighbor",
				"Bacteria: The @Override tag is used in all the appropriate places."));

		assertEquals("passed", checkOverride("Virus.java", "touchNeighbor",
				"Virus: The @Override tag is used in all the appropriate places."));

		assertEquals("passed", checkPrivacy("Entity.java", "String", "dna",
				"Entity: All appropriate attributes are private and commented."));
		assertEquals("passed", checkPrivacy("Entity.java", "Strength", "strength",
				"Entity: All appropriate attributes are private and commented."));
		// assertEquals("passed", checkPrivacy("Entity.java", "Entity[]", "bloodstream",
		// "Entity: All appropriate attributes are private."));
		assertEquals("passed", checkPrivacy("WhiteBloodCell.java", "String", "nucleusType",
				"WhiteBloodCell: All appropriate attributes are private and commented."));
		assertEquals("passed", checkPrivacy("WhiteBloodCell.java", "Entity[]", "targets",
				"WhiteBloodCell: All appropriate attributes are private and commented."));
		assertEquals("passed", checkPrivacy("Neutrophil.java", "boolean", "sniffCytokines",
				"Neutrophil: All appropriate attributes are private and commented."));
		assertEquals("passed", checkPrivacy("Macrophage.java", "int", "count",
				"Macrophage: All appropriate attributes are private and commented."));
		assertNotEquals(0, ++passed);
	}

	private String checkPrivacy(String filename, String type, String attribute, String errorMsg) {
		String line = null;
		try {
			FileReader fReader = new FileReader(filename);
			BufferedReader bReader = new BufferedReader(fReader);

			while ((line = bReader.readLine()) != null) {
				// System.out.println("(line.contains (//) || line.contains(/*))" +
				// (line.contains ("//") || line.contains("/*")));
				line = line.trim();
				if (!line.isEmpty())
					if (line.contains("private") && line.contains(type) && line.contains(attribute)
							&& line.contains(";") && (line.contains("//") || line.contains("/*")))
						return "passed";
			}
			bReader.close();
		} catch (Exception e) {
			return "NOT MET: Couldn't open " + filename;
		}
		return errorMsg;
	}

	private String checkSuperCtor(String className, String errorMsg) {
		ArrayList<String> body = pullMethodBody(className + ".java",
				"(\\s*)public(\\s*)" + className + "(\\s*)\\([a-zA-Z0-9 ,\\[\\]]*\\)(\\s*)\\{(.*)");
		for (int i = 0; i < body.size(); i++) {
			System.out.println(body.get(i));
			if (body.get(i).matches("(\\s*)super\\((.*);"))
				return "passed";
		}
		return errorMsg;
	}

	private String checkShadowing(String filename, String type, String variable, String errorMsg) {
		String line = null;
		try {
			FileReader fReader = new FileReader(filename);
			BufferedReader bReader = new BufferedReader(fReader);

			while ((line = bReader.readLine()) != null) {
				line = line.trim();
				if (!line.isEmpty())
					if (line.contains(type) && line.contains(" " + variable) && !line.contains(",")
							&& !line.contains(")"))
						return errorMsg;
			}
			bReader.close();
		} catch (Exception e) {
			return "NOT MET: Couldn't open " + filename;
		}
		return "passed";
	}

	private String checkParentCall(String filename, String method, String errorMsg) {
		ArrayList<String> body = pullMethodBody(filename,
				"(\\s*)public(\\s*)String(\\s*)touchNeighbor(\\s*)\\([a-zA-Z ]+\\)(\\s*)\\{(.*)");
		for (int i = 0; i < body.size(); i++) {
			System.out.println("********************" + body.get(i));
			if (body.get(i).matches("(.*)super\\." + method + "\\((.*)"))
				return "passed";
		}
		return errorMsg;
	}

	private String checkOverride(String filename, String method, String errorMsg) {
		String line = null;
		try {
			FileReader fReader = new FileReader(filename);
			BufferedReader bReader = new BufferedReader(fReader);

			while ((line = bReader.readLine()) != null) {
				line = line.trim();
				if (!line.isEmpty()) {
					if (line.contains("@Override")) {
						while ((line = bReader.readLine()).trim().isEmpty()) {
							// spin until next line found
						}
						if (line.contains("public") && (line.contains("void") || line.contains("String"))
								&& line.contains(method) && !line.contains("abstract"))
							return "passed";
					}
				}
			}
			bReader.close();
		} catch (Exception e) {
			return "NOT MET: Couldn't open " + filename;
		}
		return errorMsg;
	}

	private String checkAbstractTouchNeighbor() {
		String line = null;
		try {
			FileReader fReader = new FileReader("WhiteBloodCell.java");
			BufferedReader bReader = new BufferedReader(fReader);

			while ((line = bReader.readLine()) != null) {
				line = line.trim();
				if (!line.isEmpty()) {
					if (line.contains("public") && (line.contains("void") || line.contains("String"))
							&& line.contains("touchNeighbor") && line.contains("Entity"))
						return "passed";
				}
			}
			bReader.close();
		} catch (Exception e) {
			return "NOT MET: Couldn't open WhiteBloodCell.java";
		}
		return "NOT MET: WhiteBloodCell should implement the parent's touchNeighbor method.";
	}

	private String checkAbstract(String method, String errorMsg) {
		String line = null;
		try {
			FileReader fReader = new FileReader("WhiteBloodCell.java");
			BufferedReader bReader = new BufferedReader(fReader);

			while ((line = bReader.readLine()) != null) {
				line = line.trim();
				if (!line.isEmpty()) {
					if (line.contains("public") && (line.contains("String") || line.contains("void"))
							&& line.contains(method) && line.contains("abstract"))
						return "passed";
				}
			}
			bReader.close();
		} catch (Exception e) {
			return "NOT MET: Couldn't open WhiteBloodCell.java";
		}
		return errorMsg;
	}

	public String checkTouchNeighborCallsAbsorb() {
		ArrayList<String> body = pullMethodBody("WhiteBloodCell.java",
				"(\\s*)public(\\s*)String(\\s*)touchNeighbor(\\s*)\\([a-zA-Z ]+\\)(\\s*)\\{(.*)");
		for (int i = 0; i < body.size(); i++) {
			System.out.println("-------------------------------" + body.get(i));
			if (body.get(i).matches("(.*)absorb\\([a-zA-Z1-9_]+\\)(.*)"))
				return "passed";
		}
		return "NOT MET: WhiteBloodCell's touchNeighbor method should call its absorb method.";
	}

	public static StringBuffer systemCall(String cmd) {
		StringBuffer result = new StringBuffer();
		try {
			System.err.println("doing " + cmd);
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(cmd);
			pr.waitFor();
			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
			String line = null;

			while ((line = buf.readLine()) != null)
				result.append(line + "\n");
			buf.close();
			buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null)
				result.append(line + "\n");
			buf.close();
			pr.getOutputStream().close();
			pr.destroy();
		} catch (Exception e) {
			StackTraceElement[] elts = e.getStackTrace();
			for (int i = 0; i < elts.length; i++)
				result.append(elts[i].toString() + "\n");
		}
		return result;
	}

	private ArrayList<String> pullMethodBody(String filename, String methodRegex) {
		ArrayList<String> body = new ArrayList<String>();
		String line = null;
		int brackets = 0;
		boolean found = false;
		int bodyBrackets = 0;
		try {
			FileReader fReader = new FileReader(filename);
			BufferedReader bReader = new BufferedReader(fReader);

			while ((line = bReader.readLine()) != null) {
				System.out.println(line);
				line = line.trim();
				if (!line.isEmpty()) {
					if (line.matches(methodRegex) && line.contains("{")) {
						// System.out.println("FOUND METHOD*************");
						bodyBrackets = brackets;
						brackets++;
						found = true;
					} else if (line.contains("{"))
						brackets++;
					if (line.contains("}"))
						brackets--;

					if (found) {
						body.add(line);
						// System.out.println("BRACKETS************* " + brackets);
						// System.out.println("BODYBRACKETS************* " + bodyBrackets);
					}

					if (found && brackets == bodyBrackets)
						return body;
				}
			}
			bReader.close();
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Test
	public void countPassed() {
		System.out.println(systemCall(
				"curl -k    https://cs.gmu.edu/~kdobolyi/sparc/process.php?user=sparc_57HFEYSW12345678-sample_ass4_1-PROGRESS"));
		assertEquals(15, passed);
		if (passed == 15)
			System.out.println(systemCall(
					"curl -k    https://cs.gmu.edu/~kdobolyi/sparc/process.php?user=sparc_57HFEYSW12345678-sample_ass4_1-COMPLETED"));

	}

}
