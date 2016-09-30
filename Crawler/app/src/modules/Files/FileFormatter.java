package modules.WebTools;

public class FileFormatter extends modules.common.FileFormatter{

	public class FileFormatter(File file){


		super(file);

	}

	public class FileReaderFormatter{

		public List<String,String> ReadURL(){


			this.BeforeRead();
			super.ReadURL();
			this.AfterRead();

		}

		public void  BeforeRead(){




		}

		public void AfterRead(){


		}
	}

	public class FileWriterFormatter{









	}











}
