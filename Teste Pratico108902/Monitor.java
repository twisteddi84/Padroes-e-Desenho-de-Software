public abstract class Monitor {
        protected StudentAdm adm;
        private Student st1;

        public Monitor(StudentAdm adm) {
                this.adm = adm;
                this.st1 = adm.getStudent();
        }

        public abstract void update(StudentAdm adm);
}
